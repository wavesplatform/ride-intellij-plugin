package com.wavesplatform.rideplugin.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.RideLexerAdapter
import com.wavesplatform.rideplugin.parser.RideParserDefinition


class RideSyntaxHighlighter : SyntaxHighlighterBase() {

    private val attributes: Map<IElementType, TextAttributesKey> = HashMap()

    companion object {
        val KEYWORDS = TextAttributesKey.createTextAttributesKey("RIDE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val NUMBER = TextAttributesKey.createTextAttributesKey("RIDE_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val STRING = TextAttributesKey.createTextAttributesKey("RIDE_STRING", DefaultLanguageHighlighterColors.STRING)
        val OPERATORS = TextAttributesKey.createTextAttributesKey("RIDE_OPERATORS", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey("RIDE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("RIDE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val COMMA =
            TextAttributesKey.createTextAttributesKey("RIDE_COMMA", DefaultLanguageHighlighterColors.COMMA)
        val COLON = TextAttributesKey.createTextAttributesKey("RIDE_COLON", HighlighterColors.TEXT)

        val BRACKETS = TextAttributesKey.createTextAttributesKey("RIDE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val PARENTHESES = TextAttributesKey.createTextAttributesKey("RIDE_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
        val BRACES = TextAttributesKey.createTextAttributesKey("RIDE_BRACES", DefaultLanguageHighlighterColors.BRACES)
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("RIDE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val DIRECTIVE =
            TextAttributesKey.createTextAttributesKey("RIDE_DIRECTIVE", DefaultLanguageHighlighterColors.METADATA)
        val ANNOTATION =
            TextAttributesKey.createTextAttributesKey("RIDE_ANNOTATION", DefaultLanguageHighlighterColors.METADATA)
        val FUNCTION = TextAttributesKey.createTextAttributesKey("RIDE_FUNCTION", DefaultLanguageHighlighterColors.STATIC_METHOD)
        val TYPE = TextAttributesKey.createTextAttributesKey("RIDE_TYPE", DefaultLanguageHighlighterColors.IDENTIFIER)

    }

    init {
        fillMap(attributes, RideParserDefinition.DIRECTIVE, DIRECTIVE)
        fillMap(attributes, RideParserDefinition.ANNOTATION, ANNOTATION)
        fillMap(attributes, RideParserDefinition.FUNCTION, FUNCTION)
        fillMap(attributes, RideParserDefinition.TYPE, TYPE)
        fillMap(attributes, RideParserDefinition.KEYWORDS, KEYWORDS)
        fillMap(attributes, RideParserDefinition.NUMBERS, NUMBER)
        fillMap(attributes, RideParserDefinition.STRINGS, STRING)
        //fillMap(attributes, RideParserDefinition.OPERATORS, OPERATORS)
        //fillMap(attributes, RideParserDefinition.IDENTIFIER, IDENTIFIER)
        fillMap(attributes, RideParserDefinition.COMMA, COMMA)
        fillMap(attributes, RideParserDefinition.PARENTHESES, PARENTHESES)
        fillMap(attributes, RideParserDefinition.COLON, COLON)
        fillMap(attributes, RideParserDefinition.BRACKETS, BRACKETS)
        fillMap(attributes, RideParserDefinition.BRACES, BRACES)
        fillMap(attributes, RideParserDefinition.COMMENT, COMMENT)
    }

    override fun getHighlightingLexer(): Lexer {
        return RideLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(attributes[tokenType])
    }
}