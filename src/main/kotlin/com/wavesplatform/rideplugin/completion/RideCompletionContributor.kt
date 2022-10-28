package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.psi.RideIfExpr
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
//        registerStandardCompletion(ifPattern(), false, IF)
        registerStandardCompletion(elsePattern(), false, ELSE)
        registerStandardCompletion(letPattern(), true, LET)
//        registerStandardCompletion(funPattern(), false, FUNCTION)
    }


    companion object {
        private const val LET = "let"
        private const val FUNCTION = "fn"
        private const val IF = "if"
        private const val ELSE = "else"
        private const val ASSIGN = "="

//        fun ifPattern(): PsiElementPattern.Capture<PsiElement> {
//            return PlatformPatterns.psiElement().andOr(
//                PlatformPatterns.psiElement().withSuperParent(2, MonkeyLetStatement::class.java).and(
//                    PlatformPatterns.psiElement().afterLeaf(ASSIGN)
//                ),
//                PlatformPatterns.psiElement().insideStarting(PlatformPatterns.psiElement(RideStatement::class.java))
//                    .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
//            )
//        }

        fun letPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement()
                .insideStarting(PlatformPatterns.psiElement(RideStatement::class.java))
                .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
        }

        fun elsePattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement().withSuperParent(
                2, PlatformPatterns.psiElement().afterSiblingSkipping(
                    PlatformPatterns.psiElement().whitespaceCommentEmptyOrError(),
                    PlatformPatterns.psiElement().withFirstChild(
                        PlatformPatterns.psiElement(RideIfExpr::class.java)
                    )
                )
            )
        }

//        fun funPattern(): PsiElementPattern.Capture<PsiElement> {
//            return PlatformPatterns.psiElement().andOr(
//                PlatformPatterns.psiElement().withSuperParent(2, MonkeyLetStatement::class.java).and(
//                    PlatformPatterns.psiElement().afterLeaf(ASSIGN)
//                ),
//                PlatformPatterns.psiElement().insideStarting(PlatformPatterns.psiElement(MonkeyStatement::class.java))
//                    .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
//            )
//        }
    }
}