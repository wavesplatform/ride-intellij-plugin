package com.wavesplatform.rideplugin.refactor

import com.intellij.patterns.ElementPattern
import com.intellij.patterns.ElementPatternCondition
import com.intellij.patterns.InitialPatternCondition
import com.intellij.psi.PsiElement
import com.intellij.refactoring.rename.RenameInputValidator
import com.intellij.util.ProcessingContext
import com.wavesplatform.rideplugin.psi.RideNamedElement
import com.wavesplatform.rideplugin.psi.RideSimpleRefExpr

val regex = Regex("[a-zA-Z]+")

class RideRenameInputValidator : RenameInputValidator {
    private val pattern = object : ElementPattern<PsiElement> {
        private val condition =
            ElementPatternCondition(object : InitialPatternCondition<PsiElement>(PsiElement::class.java) {
                override fun accepts(o: Any?, context: ProcessingContext?) = false
            })

        override fun accepts(o: Any?): Boolean = o is RideNamedElement || o is RideSimpleRefExpr

        override fun accepts(o: Any?, context: ProcessingContext?): Boolean = accepts(o)

        override fun getCondition(): ElementPatternCondition<PsiElement> = condition
    }

    override fun getPattern(): ElementPattern<out PsiElement> = pattern

    override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
        return regex.matches(newName)
    }
}
