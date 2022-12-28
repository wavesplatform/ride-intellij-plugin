package com.wavesplatform.rideplugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.RideFileType
import org.jaxen.expr.FunctionCallExpr

object RideElementFactory {
    private const val virtualFileName = "Dummy.ride"

    private fun createFile(project: Project, text: String): RideFile {
        return PsiFileFactory.getInstance(project)
            .createFileFromText(virtualFileName, RideFileType.INSTANCE, text) as RideFile
    }

    private inline fun <reified E : PsiElement> createElementOrNull(
        project: Project,
        text: String,
    ): E? {
        return PsiTreeUtil.findChildrenOfType(createFile(project, text), E::class.java).lastOrNull()
    }

    private inline fun <reified E : PsiElement> createElement(
        project: Project,
        text: String,
    ): E = createElementOrNull(project, text) ?: cannotCreateElement()

    private inline fun <reified E> cannotCreateElement(): E =
        throw IllegalStateException("Cannot create an element ${E::class}")

    @JvmStatic
    fun createFunctionName(project: Project, name: String): RideInvokeFunctionName {
        val functionInvocation = "${name}()"
        return createElement(project, functionInvocation)
    }

    @JvmStatic
    fun createVarName(project: Project, name: String): RideSimpleRefExpr {
        //al fakeParam = name
        return createElement(project, name)
    }

}
