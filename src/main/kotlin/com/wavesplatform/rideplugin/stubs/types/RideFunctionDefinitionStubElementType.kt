package com.wavesplatform.rideplugin.stubs.types

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.wavesplatform.rideplugin.psi.RideAll
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import com.wavesplatform.rideplugin.psi.RideVarDefinition
import com.wavesplatform.rideplugin.psi.impl.RideFunctionDefinitionImpl
import com.wavesplatform.rideplugin.psi.impl.RideVarDefinitionImpl
import com.wavesplatform.rideplugin.stubs.RideFunctionDefinitionStub
import com.wavesplatform.rideplugin.stubs.RideVarDefinitionStub

class RideFunctionDefinitionStubElementType(debugName: String) :
    RideNamedStubElementType<RideFunctionDefinitionStub, RideFunctionDefinition>(debugName) {
    override fun serialize(stub: RideFunctionDefinitionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun shouldCreateStub(node: ASTNode?): Boolean {
        val psi = node?.psi
        if (psi !is RideVarDefinition) {
            return false
        }
        return psi.parent?.parent?.parent is RideAll
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): RideFunctionDefinitionStub {
        return RideFunctionDefinitionStub(parentStub, this, dataStream.readName())
    }

    override fun createPsi(stub: RideFunctionDefinitionStub): RideFunctionDefinition {
        return RideFunctionDefinitionImpl(stub, this)
    }

    override fun createStub(psi: RideFunctionDefinition, parentStub: StubElement<*>?): RideFunctionDefinitionStub {
        return RideFunctionDefinitionStub(parentStub, this, psi.name)
    }
}
