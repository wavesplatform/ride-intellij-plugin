package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement

class RideKeywordCompletionContributor : CompletionContributor() {
    private fun registerStandardCompletion(pattern: ElementPattern<out PsiElement?>, vararg keywords: String) {
        extend(
            CompletionType.BASIC,
            pattern,
            RideKeywordCompletionProvider(listOf(*keywords), true)
        )
    }

    init {
        registerStandardCompletion(
            RidePatterns.VariableDefinitionPatterns.varDefinitionPattern(),
            RideKeywords.LET,
            RideKeywords.STRICT
        )
        registerStandardCompletion(RidePatterns.FunctionPatterns.functionPattern(), RideKeywords.FUNC)
        registerStandardCompletion(RidePatterns.IfPattern.ifPattern(), RideKeywords.IF)
        registerStandardCompletion(RidePatterns.IfPattern.thenPattern(), RideKeywords.THEN)
        registerStandardCompletion(RidePatterns.IfPattern.elsePattern(), RideKeywords.ELSE)
        registerStandardCompletion(RidePatterns.MatchPattern.matchPattern(), RideKeywords.MATCH)
        registerStandardCompletion(RidePatterns.MatchPattern.casePattern(), RideKeywords.CASE)
        registerStandardCompletion(RidePatterns.LiteralPattern.literalPattern(),
            RideKeywords.TRUE,
            RideKeywords.FALSE,
            RideKeywords.UNIT,
            RideKeywords.NIL,
            RideKeywords.BASE16,
            RideKeywords.BASE58,
            RideKeywords.BASE64,
        )
        registerStandardCompletion(RidePatterns.FoldPattern.foldPattern(), RideKeywords.FOLD)
    }
}
