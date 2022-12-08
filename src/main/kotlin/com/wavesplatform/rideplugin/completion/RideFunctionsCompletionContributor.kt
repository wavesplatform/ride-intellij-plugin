package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import com.wavesplatform.rideplugin.icons.RideIcons
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition

class RideFunctionsCompletionContributor : CompletionContributor(), DumbAware {
    init {
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(
                parameters: CompletionParameters,
                context: ProcessingContext,
                result: CompletionResultSet
            ) {

                val declaredFunctions = PsiTreeUtil
                    .findChildrenOfType(
                        parameters.originalPosition?.containingFile,
                        RideFunctionDefinition::class.java
                    ).map { it.text }

                declaredFunctions
                    .asSequence()
                    .map { "$it()" }
                    .map(LookupElementBuilder::create)
                    .map {
                        it.withInsertHandler { context, item ->
                            val start = context.startOffset
                            val end = context.selectionEndOffset
                            context.editor.caretModel.moveToOffset(end - 1)
                        }
                    }
                    .map {
                        it.withIcon(RideIcons.FUNCTION)
                            .withTypeIconRightAligned(true)
                    }
                    .map(result::addElement)
                    .toList()
            }
        }
        extend(
            CompletionType.BASIC,
            RidePatterns.InvocationPattern.functionCallPattern(),
            provider
        )
    }
}