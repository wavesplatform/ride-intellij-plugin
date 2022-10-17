package com.wavesplatform.rideplugin.psi.impl

import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.stubs.types.RideVarDefinitionStubElementType

object RideElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        if (name == "VAR_DEFINITION") return RideVarDefinitionStubElementType(name)
        throw RuntimeException("Unknown element type: $name")
    }
}
