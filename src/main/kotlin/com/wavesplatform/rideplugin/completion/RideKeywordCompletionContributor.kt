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
    }
}
