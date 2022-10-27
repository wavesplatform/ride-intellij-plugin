package com.wavesplatform.rideplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class RideFileType : LanguageFileType(RideLanguage.INSTANCE) {
    override fun getName(): String {
        return "Ride File"
    }

    override fun getDescription(): String {
        return "Ride language file"
    }

    override fun getDefaultExtension(): String {
        return "ride"
    }

    override fun getIcon(): Icon {
        return RideIcons.FILE
    }

    companion object {
        @JvmStatic
        val INSTANCE = RideFileType()
    }
}