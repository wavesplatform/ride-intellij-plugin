package com.wavesplatform.rideplugin.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.wavesplatform.rideplugin.psi.impl.RideCompositeElementImpl
import com.wavesplatform.rideplugin.resolve.RideFunctionReference

open class RideFunctionNameMixin(node: ASTNode) : RideCompositeElementImpl(node) {

    override fun getReference(): PsiReference {
        return RideFunctionReference(this, TextRange(0, textLength))
    }
}
