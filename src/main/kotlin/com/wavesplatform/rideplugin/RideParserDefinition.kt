package com.wavesplatform.rideplugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.wavesplatform.rideplugin.parser.RideParser
import com.wavesplatform.rideplugin.psi.RideTypes


class RideParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return RideLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
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
        val COMMENTS = TokenSet.create(RideTypes.COMMENT)
        val FILE = IFileElementType(RideLanguage.INSTANCE)
    }
}