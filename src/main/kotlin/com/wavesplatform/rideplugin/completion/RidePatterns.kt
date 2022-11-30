package com.wavesplatform.rideplugin.completion

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.psi.*

object RidePatterns {

    object VariableDefinitionPatterns {
        @JvmStatic
        fun varDefinitionPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement()
                .inside(psiElement(RideAll::class.java))
                .andNot(psiElement().afterLeaf(psiElement(RideTypes.ASSIGN)))
        }
    }

    object FunctionPatterns {
        @JvmStatic
        fun functionPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().withSuperParent(3, RideAll::class.java)
        }
    }

    object IfPattern {
        @JvmStatic
        fun ifPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideAll::class.java)
        }

        @JvmStatic
        fun thenPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideIfExpr::class.java)
        }

        @JvmStatic
        fun elsePattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().withSuperParent(
                2, psiElement().afterSiblingSkipping(
                    psiElement().whitespaceCommentEmptyOrError(),
                    psiElement().withFirstChild(
                        psiElement(RideIfExpr::class.java)
                    )
                )
            )
        }
    }

    object MatchPattern {
        @JvmStatic
        fun matchPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideAll::class.java)
        }

        @JvmStatic
        fun casePattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().withSuperParent(
                2, psiElement().afterSiblingSkipping(
                    psiElement().whitespaceCommentEmptyOrError(),
                    psiElement().withFirstChild(
                        psiElement(RidePatternMatchingExpr::class.java)
                    )
                )
            )
        }
    }

    object LiteralPattern {
        @JvmStatic
        fun literalPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().andOr(
                psiElement().inside(RideClosure::class.java),
                psiElement().afterLeaf(psiElement(RideTypes.ASSIGN))
            )
        }
    }

    object FoldPattern {
        @JvmStatic
        fun foldPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideClosure::class.java)
        }
    }

    object BaseTypePattern {
        @JvmStatic
        fun baseTypePattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().andOr(
                psiElement().inside(RideParamDefinition::class.java),
                psiElement().afterLeaf(psiElement(RideTypes.COLON))
            )
        }
    }

    object InvocationPattern {
        @JvmStatic
        fun structCreationPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideClosure::class.java).andNot(
                psiElement().afterLeaf(psiElement(RideTypes.COLON))
            )
        }

        @JvmStatic
        fun functionCallPattern(): PsiElementPattern.Capture<PsiElement> {
            return psiElement().inside(RideClosure::class.java).andNot(
                psiElement().afterLeaf(psiElement(RideTypes.COLON))
            )
        }
    }
}
