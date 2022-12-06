package com.wavesplatform.rideplugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import com.wavesplatform.rideplugin.psi.RideVarDefinition
import com.wavesplatform.rideplugin.stubs.RideFunctionDefinitionStub

abstract class RideFunctionDefinitionBaseImpl :
    RideNamedStubbedPsiElementBase<RideFunctionDefinitionStub>,
    RideFunctionDefinition {
    constructor(stub: RideFunctionDefinitionStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun getName(): String {
        val stub = stub
        return if (stub != null) StringUtil.notNullize(stub.name) else this.nameIdentifier!!.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.node.psi
    }

    override fun setName(name: String): PsiElement {
        TODO()
    }
}
