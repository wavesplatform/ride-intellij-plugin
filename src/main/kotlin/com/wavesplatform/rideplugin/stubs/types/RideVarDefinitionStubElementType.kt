package com.wavesplatform.rideplugin.stubs.types

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.wavesplatform.rideplugin.psi.RideAll
import com.wavesplatform.rideplugin.psi.RideVarDefinition
import com.wavesplatform.rideplugin.psi.impl.RideVarDefinitionImpl
import com.wavesplatform.rideplugin.stubs.RideVarDefinitionStub

class RideVarDefinitionStubElementType(debugName: String) :
    RideNamedStubElementType<RideVarDefinitionStub, RideVarDefinition>(debugName) {
    override fun serialize(stub: RideVarDefinitionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun shouldCreateStub(node: ASTNode?): Boolean {
        val psi = node?.psi
        if (psi !is RideVarDefinition) {
            return false
        }
        return psi.parent?.parent?.parent is RideAll
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): RideVarDefinitionStub {
        return RideVarDefinitionStub(parentStub, this, dataStream.readName())
    }

    override fun createPsi(stub: RideVarDefinitionStub): RideVarDefinition {
        return RideVarDefinitionImpl(stub, this)
    }

    override fun createStub(psi: RideVarDefinition, parentStub: StubElement<*>?): RideVarDefinitionStub {
        return RideVarDefinitionStub(parentStub, this, psi.name)
    }
}
