package com.wavesplatform.rideplugin.completion

import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.psi.PsiElement

object RideCompletionUtil {
    @JvmStatic
    fun shouldComplete(element: PsiElement): Boolean {
        // There are problems with unnecessary completion after numbers/etc
        return element.text != CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED
    }
}
