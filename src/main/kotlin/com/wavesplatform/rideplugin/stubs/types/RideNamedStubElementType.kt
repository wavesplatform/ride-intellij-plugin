package com.wavesplatform.rideplugin.stubs.types

import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.NamedStubBase
import com.wavesplatform.rideplugin.psi.RideNamedElement
import com.wavesplatform.rideplugin.stubs.RideFunctionNameIndex
import com.wavesplatform.rideplugin.stubs.RideVarNameIndex

abstract class RideNamedStubElementType<S : NamedStubBase<T>, T : RideNamedElement>
    (debugName: String) : RideStubElementType<S, T>(debugName) {
    override fun indexStub(stub: S, sink: IndexSink) {
        val name = stub.name
        if (name != null) {
            sink.occurrence(RideVarNameIndex.KEY, name)
            sink.occurrence(RideFunctionNameIndex.KEY, name)
        }
    }
}
