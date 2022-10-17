package com.wavesplatform.rideplugin.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.RideLexerAdapter
import com.wavesplatform.rideplugin.psi.RideTypes


class RideSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return RideLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType == RideTypes.ASSIGN) {
            return SEPARATOR_KEYS
        }
        if (tokenType == RideTypes.IDENTIFIER) {
            return KEY_KEYS
        }
        if (tokenType == RideTypes.IDENTIFIER) {
            return VALUE_KEYS
        }
        if (tokenType == RideTypes.COMMENT) {
            return COMMENT_KEYS
        }
        return if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else EMPTY_KEYS
    }

    companion object {
        val SEPARATOR = TextAttributesKey.createTextAttributesKey(
            "SIMPLE_SEPARATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val KEY = TextAttributesKey.createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE = TextAttributesKey.createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}