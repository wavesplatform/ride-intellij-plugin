package com.wavesplatform.rideplugin.resolve

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.psi.RideElementFactory
import com.wavesplatform.rideplugin.psi.RideSimpleRefExpr
import com.wavesplatform.rideplugin.psi.RideVarDefinition
import java.util.*

class RideVarReference(psiElement: PsiElement, range: TextRange) : RideReferenceBase(psiElement, range) {

    override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
        return PsiTreeUtil
            .findChildrenOfType(
                element.containingFile, RideVarDefinition::class.java
            )
            .filter { Objects.equals(it.text, element.text) }
    }

    override fun handleElementRename(newElementName: String): PsiElement? {
        return when (element) {
            is RideSimpleRefExpr ->
                psiElement.replace(RideElementFactory.createVarName(psiElement.project, newElementName))

            else -> return null
        }
    }
}