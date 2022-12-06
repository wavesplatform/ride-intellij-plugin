package com.wavesplatform.rideplugin.psi.impl

import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.stubs.types.RideFunctionDefinitionStubElementType
import com.wavesplatform.rideplugin.stubs.types.RideVarDefinitionStubElementType

object RideElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        return when (name) {
            "VAR_DEFINITION" -> RideVarDefinitionStubElementType(name)
            "FUNCTION_DEFINITION" -> RideFunctionDefinitionStubElementType(name)
            else -> throw RuntimeException("Unknown element type: $name")
        }
    }
}
