package com.wavesplatform.rideplugin.inspection

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInspection.*
import com.intellij.codeInspection.ex.GlobalInspectionContextImpl
import com.intellij.codeInspection.ex.GlobalInspectionContextUtil
import com.intellij.codeInspection.reference.RefElement
import com.intellij.codeInspection.ui.InspectionToolPresentation
import com.intellij.lang.annotation.Annotation
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.Key
import com.intellij.profile.codeInspection.InspectionProjectProfileManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.ContainerUtil
import com.wavesplatform.rideplugin.RideFile
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
        val currentProfile = InspectionProjectProfileManager.getInstance(project).currentProfile
        val toolWrapper = currentProfile.getInspectionTool(SHORT_NAME, project) ?: return


    }

    override fun getDisplayName(): String = "Compiler"

    override fun getShortName(): String = SHORT_NAME

    companion object {
        const val SHORT_NAME: String = "RideCompiler"

        private val ANALYZED_FILES: Key<MutableSet<RideFile>> = Key.create("ANALYZED_FILES")

        /** TODO: Use [ProblemDescriptorUtil.convertToProblemDescriptors] instead */
        private fun convertToProblemDescriptors(annotations: List<Annotation>, file: PsiFile): List<ProblemDescriptor> {
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