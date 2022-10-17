package com.wavesplatform.rideplugin.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface RideNamedElement : RideCompositeElement, PsiNameIdentifierOwner, NavigatablePsiElement
