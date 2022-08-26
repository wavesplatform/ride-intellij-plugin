package com.wavesplatform.rideplugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider


class RideFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RideLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return RideFileType.INSTANCE
    }

    override fun toString(): String {
        return "Ride File"
    }
}