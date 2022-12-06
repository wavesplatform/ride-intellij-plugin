package com.wavesplatform.rideplugin.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.highlighter.RideSyntaxHighlighter
import com.wavesplatform.rideplugin.psi.*

class RideAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is RideAnnotation -> annotateWithInfo(element, holder, RideSyntaxHighlighter.ANNOTATION)
            is RideDirective -> annotateWithInfo(element, holder, RideSyntaxHighlighter.DIRECTIVE)
            is RideFunctionDefinition, is RideInvokeFunctionName -> annotateWithInfo(
                element,
                holder,
                RideSyntaxHighlighter.FUNCTION
            )
            is RideType -> annotateWithInfo(element, holder, RideSyntaxHighlighter.TYPE)
        }
    }
}

private fun annotateWithInfo(
    element: PsiElement,
    holder: AnnotationHolder,
    attributesKey: TextAttributesKey
) {
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        .range(element.textRange)
        .textAttributes(attributesKey)
        .create()
}
