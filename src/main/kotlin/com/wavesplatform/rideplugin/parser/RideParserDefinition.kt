package com.wavesplatform.rideplugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.RideLanguage
import com.wavesplatform.rideplugin.RideLexerAdapter
import com.wavesplatform.rideplugin.psi.RideTypes


class RideParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return RideLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENT
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return RideParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return RideFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return RideTypes.Factory.createElement(node)
    }

    companion object {

        @Suppress("unused")
        @JvmStatic
        val FILE = IFileElementType(RideLanguage.INSTANCE)

        @JvmStatic
        val COLON = TokenSet.create(RideTypes.COLON)

        @JvmStatic
        val COMMENT = TokenSet.create(RideTypes.COMMENT)

        @JvmStatic
        val BRACKETS = TokenSet.create(RideTypes.RBRACKET, RideTypes.LBRACKET)

        @JvmStatic
        val BRACES = TokenSet.create(RideTypes.RBRACE, RideTypes.LBRACE)

        @JvmStatic
        val PARENTHESES = TokenSet.create(RideTypes.LPAREN, RideTypes.RPAREN)

        @JvmStatic
        val COMMA = TokenSet.create(RideTypes.COMMA)

        @JvmStatic
        val IDENTIFIER = TokenSet.create(RideTypes.UPPER_ID, RideTypes.LOWER_ID)

        @JvmStatic
        val STRINGS = TokenSet.create(RideTypes.STRING, RideTypes.SQSTRING)

        @JvmStatic
        val DIRECTIVE = TokenSet.create(RideTypes.DIRECTIVE)

        @JvmStatic
        val ANNOTATION = TokenSet.create(RideTypes.ANNOTATION)

        @JvmStatic
        val FUNCTION = TokenSet.create(RideTypes.FUNCTION_DEFINITION, RideTypes.INVOKE_FUNCTION_NAME)

        @JvmStatic
        val TYPE = TokenSet.create(RideTypes.TYPE)

        @JvmStatic
        val OPERATORS = TokenSet.create(
            RideTypes.MINUS,
            RideTypes.PLUS,
            RideTypes.SLASH,
            RideTypes.ASTERISK,
            RideTypes.LESS_OR_EQUAL,
            RideTypes.GREATER_OR_EQUAL,
            RideTypes.LESS,
            RideTypes.GT,
            RideTypes.EQ,
            RideTypes.NOT_EQ
        )

        @JvmStatic
        val NUMBERS = TokenSet.create(RideTypes.INTEGER)

        @JvmStatic
        val KEYWORDS =
            TokenSet.create(
                RideTypes.LET,
                RideTypes.FUNCTION,
                RideTypes.IF,
                RideTypes.ELSE,
                RideTypes.THEN,
                RideTypes.TRUE,
                RideTypes.FALSE,
                RideTypes.STRICT,
                RideTypes.CASE,
                RideTypes.MATCH,
                RideTypes.FOLD_KW,
                RideTypes.BASE16,
                RideTypes.BASE58,
                RideTypes.BASE64,
                RideTypes.UNIT,
                RideTypes.NIL,
            )

        @JvmStatic
        val WHITE_SPACES = TokenSet.create(
            //RideTypes.NEW_LINE,
            TokenType.WHITE_SPACE
        )
    }
}