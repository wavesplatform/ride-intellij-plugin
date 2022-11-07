package com.wavesplatform.rideplugin.editor

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.wavesplatform.rideplugin.parser.RideParserDefinition
import com.wavesplatform.rideplugin.psi.RideTypes

class RideBraceMatcher : PairedBraceMatcher {

    private val bracePairs = arrayOf(
        BracePair(RideTypes.LPAREN, RideTypes.RPAREN, false),
        BracePair(RideTypes.LBRACE, RideTypes.RBRACE, true),
        BracePair(RideTypes.LBRACKET, RideTypes.RBRACKET, false)
    )

    override fun getPairs(): Array<BracePair> {
       return bracePairs
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
       return !RideParserDefinition.STRINGS.contains(contextType) &&
               contextType != RideTypes.LPAREN &&
               contextType != RideTypes.LBRACE &&
               contextType != RideTypes.LBRACKET
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}
