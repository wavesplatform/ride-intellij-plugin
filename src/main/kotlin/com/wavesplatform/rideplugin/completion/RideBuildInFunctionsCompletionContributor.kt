package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.project.DumbAware
import com.intellij.util.ProcessingContext
import com.wavesplatform.rideplugin.icons.RideIcons

class RideBuildInFunctionsCompletionContributor : CompletionContributor(), DumbAware {
    init {
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(
                parameters: CompletionParameters,
                context: ProcessingContext,
                result: CompletionResultSet
            ) {
                mathematicalFunctions()
                    .asSequence()
                    .plus(blockchainFunctions())
                    .plus(verificationFunctions())
                    .plus(dAppFunctions())
                    .plus(decodeFunctions())
                    .plus(exceptionFunctions())
                    .plus(encodeFunctions())
                    .plus(convertFunctions())
                    .plus(byteVectorFunctions())
                    .plus(unionFunctions())
                    .plus(accountDataFunctions())
                    .plus(listFunctions())
                    .plus(stringFunctions())
                    .plus(transactionFunctions())
                    .plus(hashFunctions())
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