package com.wavesplatform.rideplugin.annotator

import com.intellij.codeHighlighting.DirtyScopeTrackingHighlightingPassFactory
import com.intellij.codeHighlighting.TextEditorHighlightingPass
import com.intellij.codeHighlighting.TextEditorHighlightingPassRegistrar
import com.intellij.codeInsight.daemon.impl.*
import com.intellij.ide.plugins.PluginManagerCore.isUnitTestMode
import com.intellij.lang.annotation.AnnotationSession
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.application.invokeLater
import com.intellij.openapi.application.runReadAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.util.BackgroundTaskUtil
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.psi.PsiFile
import com.intellij.util.ui.update.MergingUpdateQueue
import com.intellij.util.ui.update.Update
import com.wavesplatform.rideplugin.RideFile

class RideCompilationPass(
    private val factory: RideCompilationPassFactory,
    private val file: PsiFile,
    private val editor: Editor
) : TextEditorHighlightingPass(file.project, editor.document), DumbAware {
    @Suppress("UnstableApiUsage", "DEPRECATION")
    private val annotationHolder: AnnotationHolderImpl = AnnotationHolderImpl(AnnotationSession(file), false)

    @Volatile
    private var annotationInfo: Lazy<RideCompilationResult?>? = null
    private val annotationResult: RideCompilationResult? get() = annotationInfo?.value

    @Volatile
    private var disposable: Disposable = myProject

    override fun doCollectInformation(progress: ProgressIndicator) {
        annotationHolder.clear()
        if (file !is RideFile || !isAnnotationPassEnabled) return

        LOG.info("==== doCollectInformation")

        val moduleOrProject: Disposable = ModuleUtil.findModuleForFile(file) ?: myProject
//        disposable = myProject.messageBus.createDisposableOnAnyPsiChange()
//            .also { Disposer.register(moduleOrProject, it) }

//        val args = CargoCheckArgs.forTarget(myProject, cargoTarget)
//        annotationInfo = RsExternalLinterUtils.checkLazily(
//            myProject.toolchain ?: return,
//            myProject,
//            disposable,
//            cargoTarget.pkg.workspace.contentRoot,
//            args
//        )
    }

    override fun doApplyInformationToEditor() {
        if (file !is RideFile) return

        LOG.info("==== doApplyInformationToEditor")

        if (annotationInfo == null || !isAnnotationPassEnabled) {
            disposable = myProject
            doFinish(emptyList())
            return
        }

        class RsUpdate : Update(file) {
            val updateFile: RideFile = file

            override fun setRejected() {
                super.setRejected()
                doFinish(highlights)
            }

            override fun run() {
                BackgroundTaskUtil.runUnderDisposeAwareIndicator(disposable, Runnable {
                    val annotationResult = annotationResult ?: return@Runnable
                    //myProject.service<RsExternalLinterSlowRunNotifier>().reportDuration(annotationResult.executionTime)
                    runReadAction {
                        ProgressManager.checkCanceled()
                        doApply(annotationResult)
                        ProgressManager.checkCanceled()
                        doFinish(highlights)
                    }
                })
            }

            override fun canEat(update: Update?): Boolean = updateFile == (update as? RsUpdate)?.updateFile
        }

        val update = RsUpdate()
        if (isUnitTestMode) {
            update.run()
        } else {
            factory.scheduleExternalActivity(update)
        }
    }

    private fun doApply(annotationResult: RideCompilationResult) {
        if (file !is RideFile || !file.isValid) return

//        try {
//            @Suppress("UnstableApiUsage")
//            annotationHolder.runAnnotatorWithContext(file) { _, holder ->
//                holder.createAnnotationsForFile(file, annotationResult, Applicability.UNSPECIFIED)
//            }
//        } catch (t: Throwable) {
//            if (t is ProcessCanceledException) throw t
//            LOG.error(t)
//        }
    }

    private fun doFinish(highlights: List<HighlightInfo>) {
        invokeLater(ModalityState.stateForComponent(editor.component)) {
            if (Disposer.isDisposed(disposable)) return@invokeLater
            UpdateHighlightersUtil.setHighlightersToEditor(
                myProject,
                document,
                0,
                file.textLength,
                highlights,
                colorsScheme,
                id
            )
            DaemonCodeAnalyzerEx.getInstanceEx(myProject).fileStatusMap.markFileUpToDate(document, id)
        }
    }

    private val highlights: List<HighlightInfo>
        get() = annotationHolder.map(HighlightInfo::fromAnnotation)

    private val isAnnotationPassEnabled: Boolean
        get() = true//myProject.rustSettings.runExternalLinterOnTheFly

    companion object {
        private val LOG: Logger = logger<RideCompilationPass>()
    }
}

class RideCompilationPassFactory(
    project: Project,
    registrar: TextEditorHighlightingPassRegistrar
) : DirtyScopeTrackingHighlightingPassFactory {
    private val myPassId: Int = registrar.registerTextEditorHighlightingPass(
        this,
        null,
        null,
        false,
        -1
    )

    private val externalLinterQueue = MergingUpdateQueue(
        "RideCompilationQueue",
        TIME_SPAN,
        true,
        MergingUpdateQueue.ANY_COMPONENT,
        project,
        null,
        false
    )

    override fun createHighlightingPass(file: PsiFile, editor: Editor): TextEditorHighlightingPass? {
        FileStatusMap.getDirtyTextRange(editor, passId) ?: return null
        return RideCompilationPass(this, file, editor)
    }

    override fun getPassId(): Int = myPassId

    fun scheduleExternalActivity(update: Update) = externalLinterQueue.queue(update)

    companion object {
        private const val TIME_SPAN: Int = 300
    }
}

data class RideCompilationResult(val message: String)
