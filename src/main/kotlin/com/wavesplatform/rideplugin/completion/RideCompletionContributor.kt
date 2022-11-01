package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.psi.RideStatement


class RideCompletionContributor : CompletionContributor() {
    private fun registerStandardCompletion(
        pattern: ElementPattern<out PsiElement?>,
        needSpace: Boolean,
        vararg keywords: String
    ) {
        extend(
            CompletionType.BASIC,
            pattern,
            RideCompletionProvider(needSpace, listOf(*keywords))
        )
    }

    init {
        registerStandardCompletion(letPattern(), true, LET)
    }


    companion object {
        private const val LET = "let"

        fun letPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement()
                .insideStarting(PlatformPatterns.psiElement(RideStatement::class.java))
                .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
        }
    }
}