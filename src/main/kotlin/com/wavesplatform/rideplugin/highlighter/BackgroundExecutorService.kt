package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.util.concurrency.AppExecutorUtil

@Service(Service.Level.PROJECT)
class BackgroundExecutorService(project: Project): Disposable {
    val executor = AppExecutorUtil.createBoundedApplicationPoolExecutor("RIDE Compiler Background Executor", 1)
    override fun dispose() {
        executor.shutdown()
    }

    fun executeOnBackgroudThread(runnable: Runnable) {
        executor.execute(runnable)
    }

    companion object {
        fun executeInBackground(project: Project, action: () -> Unit) {
            instance(project).executeOnBackgroudThread {
                action()
            }
        }


        fun instance(project: Project) = project.getService<BackgroundExecutorService>(BackgroundExecutorService::class.java)
    }
}
