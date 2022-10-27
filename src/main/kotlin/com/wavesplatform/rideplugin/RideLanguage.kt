package com.wavesplatform.rideplugin

import com.intellij.lang.Language

class RideLanguage : Language("RIDE") {
    companion object {
        @JvmStatic
        val INSTANCE = RideLanguage()
    }
}