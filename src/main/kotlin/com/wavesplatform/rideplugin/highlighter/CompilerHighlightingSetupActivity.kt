package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.*

private val LOG = logger<CompilerHighlightingSetupActivity>()

class CompilerHighlightingSetupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        LOG.debug("Installing listeners")
        VirtualFileManager.getInstance().addAsyncFileListener(CompilerHighlightingFileListener(project)) { }
        PsiManager.getInstance(project).addPsiTreeChangeListener(object : PsiTreeChangeAdapter() {
            override fun childAdded(event: PsiTreeChangeEvent) = triggerChange(event)
            override fun childRemoved(event: PsiTreeChangeEvent) = triggerChange(event)
            private fun triggerChange(event: PsiTreeChangeEvent) {
                LOG.debug("PSI Changed: $event, psi=${event.file}, vfile=${event.file?.virtualFile}")
            }
        }) {  }
    }
}
