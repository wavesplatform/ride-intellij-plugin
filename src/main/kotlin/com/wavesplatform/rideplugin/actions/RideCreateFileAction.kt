package com.wavesplatform.rideplugin.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.wavesplatform.rideplugin.RideIcons


class RideCreateFileAction : CreateFileFromTemplateAction(CAPTION, "", RideIcons.FILE),
    DumbAware {

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String = CAPTION

    override fun isAvailable(dataContext: DataContext): Boolean {
        if (!super.isAvailable(dataContext)) return false
        val project = CommonDataKeys.PROJECT.getData(dataContext) ?: return false
        val vFile = CommonDataKeys.VIRTUAL_FILE.getData(dataContext) ?: return false
        return true
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(CAPTION)
            .addKind("Account script", null, "RideAccountScript")
            .addKind("Asset script", null, "RideAssetScript")
            .addKind("dApp script", null, "RidedAppScript")
            .addKind("Library", null, "RideLibrary")
    }

    private companion object {
        private const val CAPTION = "Ride File"
    }
}
