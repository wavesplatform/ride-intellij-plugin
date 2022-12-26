package com.wavesplatform.rideplugin.refactor

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.wavesplatform.rideplugin.psi.RideNamedElement

class RideRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean =
        element is RideNamedElement
}
