package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.AsyncFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import com.intellij.psi.PsiFile
import com.wavesplatform.lang.*
import com.wavesplatform.lang.v1.compiler.CompilationError
import scala.jdk.javaapi.CollectionConverters.asJavaCollection
import java.util.*
import java.util.concurrent.Callable

private val LOG = logger<CompilerHighlightingFileListener>()

data class HighlightInfo(
    val psiFile: PsiFile
)

class CompilerHighlightingFileListener(val project: Project) : AsyncFileListener {
    override fun prepareChange(events: MutableList<out VFileEvent>): AsyncFileListener.ChangeApplier {
        return object : AsyncFileListener.ChangeApplier {
            override fun afterVfsChange() {
                BackgroundExecutorService.executeInBackground(project, {
                    events.forEach { f ->
                        LOG.debug("$f: ${f.file}")
                        val file = f.file
                        file?.let {
                            val bytes = ReadAction.compute<ByteArray, Throwable> { file.contentsToByteArray() }
                            LOG.debug("compiling $file")
                            val errors = when (val result =
                                Lang.parseAndCompile(bytes.toString(Charsets.UTF_8), false, false)) {
                                is CompileAndParseResult.Contract ->
                                    asJavaCollection(result.errors())

                                is CompileAndParseResult.Expression ->
                                    asJavaCollection(result.errors())

                                else -> Collections.emptyList()
                            }
                            LOG.debug("errors: $errors")
                            applyHighlights(errors)
                        }
                    }
                })
            }
        }
    }

    private fun applyHighlights(errors: Collection<CompilationError>) {
        val readActionCallable: Callable<Int> = Callable {
            val allEditors = EditorFactory.getInstance().allEditors.asList().flatMap { ed ->
                listOf(1, 2, 3)
            }

            1
        }


        ReadAction
            .nonBlocking(readActionCallable)
            .inSmartMode(project)
            .expireWhen { -> project.isDisposed }

            .finishOnUiThread(ModalityState.nonModal(), { v ->
//                UpdateHighlightersUtil.setHighlightersToSingleEditor(project, )
//                ErrorStripeUpdateManager.getInstance(project).repaintErrorStripePanel(editor, psiFile)
            })
            .submit(BackgroundExecutorService.instance(project).executor)
    }
}
