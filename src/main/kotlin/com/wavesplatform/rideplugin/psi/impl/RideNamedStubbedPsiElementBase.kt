package com.wavesplatform.rideplugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.wavesplatform.rideplugin.psi.RideNamedElement

abstract class RideNamedStubbedPsiElementBase<T : StubElement<*>> :
    RideStubbedPsiElementBase<T>,
    RideNamedElement {
    constructor(stub: T, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)
}
