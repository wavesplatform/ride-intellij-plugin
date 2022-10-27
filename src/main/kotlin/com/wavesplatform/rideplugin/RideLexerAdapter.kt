package com.wavesplatform.rideplugin

import com.intellij.lexer.FlexAdapter
import com.wavesplatform.rideplugin.parser._RideLexer


class RideLexerAdapter : FlexAdapter(_RideLexer(null))