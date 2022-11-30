package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.project.DumbAware
import com.intellij.util.ProcessingContext
import com.wavesplatform.rideplugin.icons.RideIcons

class RideBaseTypesCompletionContributor : CompletionContributor(), DumbAware {
    init {
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(
                parameters: CompletionParameters,
                context: ProcessingContext,
                result: CompletionResultSet
            ) {
                baseTypes()
                    .plus(scriptActionStructs())
                    .plus(commonStructs())
                    .plus(transactionStructs())
                    .asSequence()
                    .map(LookupElementBuilder::create)
                    .map {
                        it.withIcon(RideIcons.TYPE_ALIAS)
                            .withTypeIconRightAligned(true)
                    }
                    .map(result::addElement)
                    .toList()
            }
        }
        extend(
            CompletionType.BASIC,
            RidePatterns.BaseTypePattern.baseTypePattern(),
            provider
        )
    }
}