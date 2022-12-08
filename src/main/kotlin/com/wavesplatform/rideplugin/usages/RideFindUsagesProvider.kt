package com.wavesplatform.rideplugin.usages

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.RideLexerAdapter
import com.wavesplatform.rideplugin.parser.RideParserDefinition
import com.wavesplatform.rideplugin.psi.RideAnnotationExpr
import com.wavesplatform.rideplugin.psi.RideFunctionDefinition
import com.wavesplatform.rideplugin.psi.RideNamedElement
import com.wavesplatform.rideplugin.psi.RideTypeDefinition
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.NonNls

class RideFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner = DefaultWordsScanner(
        RideLexerAdapter(),
        RideParserDefinition.IDENTIFIER,
        RideParserDefinition.COMMENT,
        RideParserDefinition.STRINGS,
        TokenSet.EMPTY,
        RideParserDefinition.OPERATORS
    )

    override fun canFindUsagesFor(element: PsiElement): Boolean = element is RideNamedElement

    @NonNls
    override fun getHelpId(element: PsiElement): String? = null

    override fun getType(element: PsiElement): @Nls String = when (element) {
        is RideAnnotationExpr -> "annotation"
        is RideTypeDefinition -> "type parameter"
        is RideFunctionDefinition -> "function"
        else -> "UNKNOWN"
    }

    override fun getDescriptiveName(element: PsiElement): @Nls String = when (element) {
        is RideNamedElement -> element.name ?: element.text
        is RideFile -> element.name
        else -> ""
    }

    override fun getNodeText(
        element: PsiElement,
        useFullName: Boolean
    ): @Nls String = when (element) {
        is RideNamedElement -> element.name ?: element.text
        else -> element.text
    }
}
