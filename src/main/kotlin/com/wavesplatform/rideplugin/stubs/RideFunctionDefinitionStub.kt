package com.wavesplatform.rideplugin.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import com.wavesplatform.rideplugin.psi.RideVarDefinition

class RideFunctionDefinitionStub : NamedStubBase<RideFunctionDefinition> {
    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: StringRef?) : super(
        parent,
        elementType,
        name
    )

    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: String?) : super(
        parent,
        elementType,
        name
    )
}
