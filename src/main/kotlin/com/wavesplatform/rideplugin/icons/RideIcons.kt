package com.wavesplatform.rideplugin.icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object RideIcons {

    val STRUCT = load("/icons/nodes/struct.svg")
    val FUNCTION = load("/icons/nodes/function.svg")
    val TYPE_ALIAS = load("/icons/nodes/typeAlias.svg")

    private fun load(path: String): Icon = IconLoader.getIcon(path, RideIcons::class.java)
}