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
        return when (tokenType) {
            RideTypes.ASSIGN -> SEPARATOR_KEYS
            RideTypes.DIRECTIVE -> DIRECTIVE_KEYS
            RideTypes.IDENT -> VALUE_KEYS
            RideTypes.COMMENT -> COMMENT_KEYS
            RideTypes.ANNOTATION -> ANNOTATION_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
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
        val DIRECTIVE =
            TextAttributesKey.createTextAttributesKey("SIMPLE_DIRECTIVE", DefaultLanguageHighlighterColors.METADATA)
        val DIRECTIVE_KEYS = arrayOf(DIRECTIVE)
        val ANNOTATION =
            TextAttributesKey.createTextAttributesKey("SIMPLE_ANNOTATION", DefaultLanguageHighlighterColors.METADATA)
        val ANNOTATION_KEYS = arrayOf(ANNOTATION)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}