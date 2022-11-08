package com.wavesplatform.rideplugin.completion

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.psi.*

object RidePatterns {

    object VariableDefinitionPatterns {
        @JvmStatic
        fun varDefinitionPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement()
                .inside(PlatformPatterns.psiElement(RideAll::class.java))
                .andNot(PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(RideTypes.ASSIGN)))
        }
    }

    object FunctionPatterns {
        @JvmStatic
        fun functionPattern(): PsiElementPattern.Capture<PsiElement> {
            return VariableDefinitionPatterns.varDefinitionPattern()
                .andNot(
                    PlatformPatterns.psiElement()
                    .inside(PlatformPatterns.psiElement(RideFuncExpr::class.java))
                )
        }
    }
}
