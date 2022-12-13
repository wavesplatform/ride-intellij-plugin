package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import com.wavesplatform.rideplugin.icons.RideIcons
import com.wavesplatform.rideplugin.psi.RideVarDefinition

class RideVarCompletionContributor : CompletionContributor(), DumbAware {
    init {
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(
                parameters: CompletionParameters,
                context: ProcessingContext,
                result: CompletionResultSet
            ) {
                val declaredVariables = PsiTreeUtil
                    .findChildrenOfType(
                        parameters.originalPosition?.containingFile,
                        RideVarDefinition::class.java
                    ).map { it.text }

                declaredVariables
                    .asSequence()
                    .map(LookupElementBuilder::create)
//                    .map {
//                        it.withInsertHandler { context, _ ->
//                            val end = context.selectionEndOffset
//                            context.editor.caretModel.moveToOffset(end - 1)
//                        }
//                    }
                    .map(result::addElement)
                    .toList()
            }
        }
        extend(
            CompletionType.BASIC,
            RidePatterns.RefPattern.varRefPattern(),
            provider
        )
    }
}