package com.wavesplatform.rideplugin.stubs.types

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.wavesplatform.rideplugin.RideLanguage
import com.wavesplatform.rideplugin.psi.RideCompositeElement

abstract class RideStubElementType<S : StubElement<T>, T : RideCompositeElement?>
    (debugName: String) :
    IStubElementType<S, T>(debugName, RideLanguage.INSTANCE) {
    override fun getExternalId(): String {
        return "ride." + super.toString()
    }
}
