package com.wavesplatform.rideplugin

import com.intellij.lexer.FlexAdapter


class RideLexerAdapter : FlexAdapter(RideLexer(null))