package com.wavesplatform.rideplugin.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.RideLanguage

class RideElementTextFactory {
    companion object {
        fun createStatementFromText(project: Project, name: String): PsiElement {
            val fileFromText: RideFile =
                createFileFromText(project, name)
            return fileFromText.firstChild.firstChild
        }

        private fun createFileFromText(project: Project, text: String): RideFile {
            return PsiFileFactory.getInstance(project)
                .createFileFromText("A.ride", RideLanguage.INSTANCE, text) as RideFile
        }
    }
}
