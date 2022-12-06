package com.wavesplatform.rideplugin.stubs

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import com.wavesplatform.rideplugin.psi.RideNamedElement

class RideFunctionNameIndex : StringStubIndexExtension<RideNamedElement>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, RideNamedElement> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, RideNamedElement> =
            StubIndexKey.createIndexKey("ride.function.name")
        const val VERSION = 0
    }
}
