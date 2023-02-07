package com.wavesplatform.rideplugin.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.progress.EmptyProgressIndicator
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.WindowManager
import com.intellij.psi.impl.AnyPsiChangeListener
import com.intellij.psi.impl.PsiManagerImpl
import com.intellij.util.messages.MessageBus
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.saveAllDocumentsAsTheyAre
import java.nio.file.Path
import java.time.Duration
import java.time.Instant
import java.util.concurrent.CompletableFuture

fun MessageBus.createDisposableOnAnyPsiChange(): Disposable {
    val disposable = Disposer.newDisposable("Dispose on PSI change")
    connect(disposable).subscribe(
        PsiManagerImpl.ANY_PSI_CHANGE_TOPIC,
        object : AnyPsiChangeListener {
            override fun beforePsiChanged(isPhysical: Boolean) {
                if (isPhysical) {
                    Disposer.dispose(disposable)
                }
            }
        }
    )
    return disposable
}

object RideCompilationUtils {
    private val LOG: Logger = logger<RideCompilationUtils>()
    fun checkLazily(
        project: Project,
        owner: Disposable
    ): Lazy<RideCompilationResult?>? {
        checkReadAccessAllowed()
        return lazy {
            if (!ApplicationManager.getApplication().isUnitTestMode) checkReadAccessNotAllowed()
            checkWrapped(project, owner)
        }
    }

    private fun checkWrapped(
        project: Project,
        owner: Disposable
    ): RideCompilationResult? {
        val widget = WriteAction.computeAndWait<RsExternalLinterWidget?, Throwable> {
            saveAllDocumentsAsTheyAre()
            val statusBar = WindowManager.getInstance().getStatusBar(project)
            statusBar?.getWidget(RsExternalLinterWidget.ID) as? RsExternalLinterWidget
        }

        val future = CompletableFuture<RideCompilationResult?>()
        val task = object : Task.Backgroundable(project, "Analyzing file...", true) {

            override fun run(indicator: ProgressIndicator) {
                widget?.inProgress = true
                future.complete(check(project, owner))
            }

            override fun onFinished() {
                widget?.inProgress = false
            }
        }
        ProgressManager.getInstance().runProcessWithProgressAsynchronously(task, EmptyProgressIndicator())
        return future.get()
    }

    private fun check(
        project: Project,
        owner: Disposable,
    ): RideCompilationResult? {
        ProgressManager.checkCanceled()
        val started = Instant.now()
        val output = toolchain
            .cargoOrWrapper(workingDirectory)
            .checkProject(project, owner, args)
            .unwrapOrElse { e ->
                LOG.error(e)
                return null
            }
        val finish = Instant.now()
        ProgressManager.checkCanceled()
        if (output.isCancelled) return null
        return RideCompilationResult(output.stdoutLines)
    }

//    private val compilationLazyResultCache =
//        ProjectCache<Key, Lazy<RideCompilationResult?>>("compilationLazyResultCache") {
//            PsiModificationTracker.MODIFICATION_COUNT
//        }
}

fun AnnotationHolder.createAnnotationsForFile(
    file: RideFile,
    annotationResult: RideCompilationResult
) {

    val doc = file.viewProvider.document
        ?: error("Can't find document for $file")

    val annotationMessage = annotationResult.message
    val annotationBuilder = newAnnotation(HighlightSeverity.ERROR, annotationMessage)
        //.tooltip(message.htmlTooltip)
        //.range(message.textRange)
        .problemGroup { annotationMessage }
        .needsUpdateOnTyping(true)

    annotationBuilder.create()
}


fun checkReadAccessAllowed() {
    check(ApplicationManager.getApplication().isReadAccessAllowed) {
        "Needs read action"
    }
}

fun checkReadAccessNotAllowed() {
    check(!ApplicationManager.getApplication().isReadAccessAllowed)
}

class RideCompilationResult(val message: String) {
    companion object {
        private val MESSAGE_REGEX = """\s*\{.*"message".*""".toRegex()
    }
}