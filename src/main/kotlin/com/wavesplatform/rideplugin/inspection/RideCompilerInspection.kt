package com.wavesplatform.rideplugin.inspection

import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInspection.*
import com.intellij.codeInspection.ProblemDescriptorUtil.convertToProblemDescriptors
import com.intellij.codeInspection.ex.GlobalInspectionContextImpl
import com.intellij.codeInspection.ex.GlobalInspectionContextUtil
import com.intellij.codeInspection.reference.RefElement
import com.intellij.codeInspection.ui.InspectionToolPresentation
import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.Annotation
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.runReadAction
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.util.Key
import com.intellij.profile.codeInspection.InspectionProjectProfileManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.ContainerUtil
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.annotator.*
import java.util.*

class RideCompilerInspection : GlobalSimpleInspectionTool() {

    override fun inspectionStarted(
        manager: InspectionManager,
        globalContext: GlobalInspectionContext,
        problemDescriptionsProcessor: ProblemDescriptionsProcessor
    ) {
        globalContext.putUserData(ANALYZED_FILES, ContainerUtil.newConcurrentSet())
    }

    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        problemsHolder: ProblemsHolder,
        globalContext: GlobalInspectionContext,
        problemDescriptionsProcessor: ProblemDescriptionsProcessor
    ) {
        if (file !is RideFile) return
        val analyzedFiles = globalContext.getUserData(ANALYZED_FILES) ?: return
        analyzedFiles.add(file)
    }

    override fun inspectionFinished(
        manager: InspectionManager,
        globalContext: GlobalInspectionContext,
        problemDescriptionsProcessor: ProblemDescriptionsProcessor
    ) {
        if (globalContext !is GlobalInspectionContextImpl) return
        val analyzedFiles = globalContext.getUserData(ANALYZED_FILES) ?: return

        val project = manager.project

        val editor = FileEditorManager.getInstance(project).selectedTextEditor
        val text = editor?.document?.text

        val currentProfile = InspectionProjectProfileManager.getInstance(project).currentProfile
        val toolWrapper = currentProfile.getInspectionTool(SHORT_NAME, project) ?: return

        while (true) {
            val disposable = project.messageBus.createDisposableOnAnyPsiChange()
                .also { Disposer.register(project, it) }

            val future = ApplicationManager.getApplication().executeOnPooledThread<RideCompilationResult?> {
                checkProjectLazily(project, disposable)?.value
            }
            val annotationResult = future.get()

            val exit = runReadAction {
                ProgressManager.checkCanceled()
                if (Disposer.isDisposed(disposable)) return@runReadAction false
                val problemDescriptors = getProblemDescriptors(analyzedFiles, annotationResult)
                val presentation = globalContext.getPresentation(toolWrapper)
                presentation.addProblemDescriptors(problemDescriptors, globalContext)
                true
            }

            if (exit) break
        }
    }

    override fun getDisplayName(): String = "Compiler"

    override fun getShortName(): String = SHORT_NAME

    companion object {
        const val SHORT_NAME: String = "RideCompiler"

        private val ANALYZED_FILES: Key<MutableSet<RideFile>> = Key.create("ANALYZED_FILES")

        private fun checkProjectLazily(
            project: Project,
            disposable: Disposable
        ): Lazy<RideCompilationResult?>? = runReadAction {
            RideCompilationUtils.checkLazily(project, disposable)
        }

        private fun convertToProblemDescriptor(annotations: List<Annotation>, file: PsiFile): List<ProblemDescriptor> {
            if (annotations.isEmpty()) return emptyList()

            val problems = ArrayList<ProblemDescriptor>(annotations.size)
            val quickFixMappingCache = IdentityHashMap<IntentionAction, LocalQuickFix>()
            for (annotation in annotations) {
                if (annotation.severity === HighlightSeverity.INFORMATION ||
                    annotation.startOffset == annotation.endOffset &&
                    !annotation.isAfterEndOfLine
                ) {
                    continue
                }

                val (startElement, endElement) =
                    if (annotation.startOffset == annotation.endOffset && annotation.isAfterEndOfLine) {
                        val element = file.findElementAt(annotation.endOffset - 1)
                        Pair(element, element)
                    } else {
                        Pair(file.findElementAt(annotation.startOffset), file.findElementAt(annotation.endOffset - 1))
                    }

                if (startElement == null || endElement == null) continue

                val highlightType = HighlightInfo.convertSeverityToProblemHighlight(annotation.severity)
                val descriptor = ProblemDescriptorBase(
                    startElement,
                    endElement,
                    annotation.message,
                    null, // quickFixes
                    highlightType,
                    annotation.isAfterEndOfLine,
                    null,
                    true,
                    false
                )
                problems.add(descriptor)
            }

            return problems
        }

        private fun InspectionToolPresentation.addProblemDescriptors(
            descriptors: List<ProblemDescriptor>,
            context: GlobalInspectionContext
        ) {
            if (descriptors.isEmpty()) return
            val problems = hashMapOf<RefElement, MutableList<ProblemDescriptor>>()

            for (descriptor in descriptors) {
                val element = descriptor.psiElement ?: continue
                val refElement = getProblemElement(element, context) ?: continue
                val elementProblems = problems.getOrPut(refElement) { mutableListOf() }
                elementProblems.add(descriptor)
            }

            for ((refElement, problemDescriptors) in problems) {
                val descriptions = problemDescriptors.toTypedArray<CommonProblemDescriptor>()
                addProblemElement(refElement, false, *descriptions)
            }
        }

        private fun getProblemDescriptors(
            analyzedFiles: Set<RideFile>,
            annotationResult: RideCompilationResult
        ): List<ProblemDescriptor> {
            val problemDescriptors = ArrayList<ProblemDescriptor>()
            for (file in analyzedFiles) {
                if (!file.isValid) continue
                @Suppress("UnstableApiUsage", "DEPRECATION")
                val annotationHolder = AnnotationHolderImpl(AnnotationSession(file))
                @Suppress("UnstableApiUsage")
                annotationHolder.runAnnotatorWithContext(file) { _, holder ->
                    holder.createAnnotationsForFile(file, annotationResult)
                }
                val descriptors = convertToProblemDescriptors(annotationHolder, file)
                descriptors.forEach {
                    problemDescriptors.add(it)
                }
            }
            return problemDescriptors
        }

        private fun getProblemElement(element: PsiElement, context: GlobalInspectionContext): RefElement? {
            val problemElement = PsiTreeUtil.getParentOfType(element, element::class.java, false)
            val refElement = context.refManager.getReference(problemElement)
            return if (refElement == null && problemElement != null) {
                GlobalInspectionContextUtil.retrieveRefElement(element, context)
            } else {
                refElement
            }
        }
    }
}