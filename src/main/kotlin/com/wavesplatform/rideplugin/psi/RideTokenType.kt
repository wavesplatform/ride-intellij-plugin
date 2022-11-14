package com.wavesplatform.rideplugin.psi

import com.intellij.psi.tree.IElementType
import com.jetbrains.rd.util.string.print
import com.jetbrains.rd.util.string.println
import com.wavesplatform.rideplugin.RideLanguage
import org.jetbrains.annotations.NonNls


class RideTokenType(@NonNls debugName: String) : IElementType(debugName, RideLanguage.INSTANCE) {
    override fun toString(): String {
        return when (val tokenName = super.toString()) {
            "IDENT" -> "identifier"
            else -> {
                return tokenName
            }
        }
    }
}