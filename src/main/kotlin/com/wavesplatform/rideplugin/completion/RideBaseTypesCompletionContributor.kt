package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.DumbAware
import com.intellij.util.ProcessingContext

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
                    //.map { "$it()" }
                    .map(LookupElementBuilder::create)
                    // важно
//                    .map {
//                        it.withInsertHandler { context, item ->
//                            val start = context.startOffset
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
            RidePatterns.BaseTypePattern.baseTypePattern(),
            provider
        )
    }
}

//private static final InsertHandler<LookupElement> INSERT_FUNCTION = (context, item) -> {
//        int start = context.getStartOffset();
//        int end = context.getSelectionEndOffset();
//        context.getDocument().replaceString(start, end, item.getLookupString() + "()");
//        context.getEditor().getCaretModel().moveToOffset(end + 1);
//    };