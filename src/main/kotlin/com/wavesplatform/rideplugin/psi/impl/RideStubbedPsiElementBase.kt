package com.wavesplatform.rideplugin.psi.impl

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.wavesplatform.rideplugin.psi.RideCompositeElement

abstract class RideStubbedPsiElementBase<T : StubElement<*>> : StubBasedPsiElementBase<T>,
    RideCompositeElement {
    constructor(stub: T, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun toString(): String {
        return elementType.toString()
    }
}
