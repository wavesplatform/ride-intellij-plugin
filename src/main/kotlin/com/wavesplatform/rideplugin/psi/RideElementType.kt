package com.wavesplatform.rideplugin.psi

import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.RideLanguage
import org.jetbrains.annotations.NonNls


class RideElementType(@NonNls debugName: String) : IElementType(debugName, RideLanguage.INSTANCE)