package com.wavesplatform.rideplugin.resolve

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import java.util.*

class RideFunctionReference(psiElement: PsiElement, range: TextRange) : RideReferenceBase(psiElement, range) {

    override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
        return PsiTreeUtil
            .findChildrenOfType(
                element.containingFile, RideFunctionDefinition::class.java
            )
            .filter { Objects.equals(it.text, element.text) }
    }
}