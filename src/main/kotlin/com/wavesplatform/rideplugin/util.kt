package com.wavesplatform.rideplugin

import com.intellij.ide.plugins.PluginManagerCore.isUnitTestMode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.impl.TrailingSpacesStripper
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.impl.FileDocumentManagerImpl
import com.intellij.openapi.util.io.StreamUtil
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Field

fun loadCodeSampleResource(ctx: Any, resource: String): String {
    val stream = ctx.javaClass.classLoader.getResourceAsStream(resource)!!
    return StreamUtil.convertSeparators(StreamUtil.readText(BufferedReader(InputStreamReader(stream))))
}

fun saveAllDocumentsAsTheyAre() {
    val documentManager = FileDocumentManager.getInstance()
    for (document in documentManager.unsavedDocuments) {
        documentManager.saveDocumentAsIs(document)
        documentManager.stripDocumentLater(document)
    }
}

private fun FileDocumentManager.stripDocumentLater(document: Document): Boolean {
    if (this !is FileDocumentManagerImpl) return false
    val trailingSpacesStripper = trailingSpacesStripperField
        ?.get(this) as? TrailingSpacesStripper ?: return false

    @Suppress("UNCHECKED_CAST")
    val documentsToStripLater = documentsToStripLaterField
        ?.get(trailingSpacesStripper) as? MutableSet<Document> ?: return false
    return documentsToStripLater.add(document)
}

private val trailingSpacesStripperField: Field? =
    initFieldSafely<FileDocumentManagerImpl>("myTrailingSpacesStripper")

private val documentsToStripLaterField: Field? =
    initFieldSafely<TrailingSpacesStripper>("myDocumentsToStripLater")

private inline fun <reified T> initFieldSafely(fieldName: String): Field? =
    try {
        T::class.java
            .getDeclaredField(fieldName)
            .apply { isAccessible = true }
    } catch (e: Throwable) {
        if (isUnitTestMode) throw e else null
    }