package com.wavesplatform.rideplugin.editor.folding

import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.psi.RideTypes

open class RideFoldingBuilder : RideCoreFoldingBuilder() {
    override fun lineComment(): IElementType? {
        return RideTypes.COMMENT
    }

    override fun comment(): IElementType? {
        return null
    }
}