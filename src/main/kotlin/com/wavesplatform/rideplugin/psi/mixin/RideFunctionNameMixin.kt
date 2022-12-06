package com.wavesplatform.rideplugin.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import com.wavesplatform.rideplugin.psi.impl.RideCompositeElementImpl
import com.wavesplatform.rideplugin.resolve.RideReferenceBase
import java.util.*

open class RideFunctionNameMixin(node: ASTNode) : RideCompositeElementImpl(node) {

    override fun getReference(): PsiReference {
        return object : RideReferenceBase(this, TextRange(0, textLength)) {
            override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                return PsiTreeUtil
                    .findChildrenOfType(
                        element.containingFile, RideFunctionDefinition::class.java
                    )
                    .filter { Objects.equals(it.text, element.text) }
            }

//            override fun handleElementRename(name: String): PsiElement {
//                return psiElement.replace(RideElementFactory.createFunctionName(psiElement.project, name))
//            }
        }
    }
}
