package com.wavesplatform.rideplugin.editor.folding

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.psi.RideCaseClosure
import com.wavesplatform.rideplugin.psi.RideClosureExpr
import com.wavesplatform.rideplugin.psi.RideMatchingClosure
import com.wavesplatform.rideplugin.psi.RideTypes

abstract class RideCoreFoldingBuilder : CustomFoldingBuilder() {
    protected abstract fun lineComment(): IElementType?
    protected abstract fun comment(): IElementType?
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is PsiFileBase || !root.isContentsLoaded) return
        if (!quick) {
            val processedComments: MutableSet<PsiElement> = HashSet()
            PsiTreeUtil.processElements(root) { element: PsiElement ->
                val node = element.node
                val type = node.elementType
                val range = element.textRange
                if (type === comment() && range.length > 2) {
                    descriptors.add(FoldingDescriptor(node, range, null, "/*...*/"))
                }
                if (type === lineComment()) {
                    addCommentFolds(element, processedComments, descriptors)
                }
                foldTypes(element, descriptors)
                true
            }
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange): String {
        return "..."
    }

    override fun isRegionCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }

    private fun foldTypes(e: PsiElement, results: MutableList<FoldingDescriptor>) {
        RideTypes.LBRACE
        when (e) {
            is RideClosureExpr,
            is RideCaseClosure,
            is RideMatchingClosure -> {
                fold(
                    e,
                    e.node.findChildByType(RideTypes.LBRACE)?.psi,
                    e.node.findChildByType(RideTypes.RBRACE)?.psi,
                    results
                )
            }
        }
    }

    private fun addCommentFolds(
        comment: PsiElement,
        processedComments: MutableSet<PsiElement>,
        result: MutableList<FoldingDescriptor>
    ) {
        if (processedComments.contains(comment)) return
        var end: PsiElement? = null
        var current = comment.nextSibling
        while (current != null) {
            val node = current.node ?: break
            val elementType = node.elementType
            if (elementType === lineComment()) {
                end = current
                processedComments.add(current)
                current = current.nextSibling
                continue
            }
            if (elementType === TokenType.WHITE_SPACE) {
                current = current.nextSibling
                continue
            }
            break
        }
        if (end != null) {
            val startOffset = comment.textRange.startOffset
            val endOffset = end.textRange.endOffset
            result.add(FoldingDescriptor(comment, startOffset, endOffset, null, "/.../"))
        }
    }

    private fun fold(
        first: PsiElement,
        second: PsiElement?,
        third: PsiElement?,
        results: MutableList<FoldingDescriptor>
    ) {
        if (second != null && third != null) {
            results.add(
                FoldingDescriptor(
                    first,
                    second.textRange.startOffset,
                    third.textRange.endOffset,
                    null,
                    "{...}"
                )
            )
        }
    }
}