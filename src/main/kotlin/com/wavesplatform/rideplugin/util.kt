package com.wavesplatform.rideplugin

import com.intellij.openapi.util.io.StreamUtil
import java.io.BufferedReader
import java.io.InputStreamReader

fun loadCodeSampleResource(ctx: Any, resource: String): String {
    val stream = ctx.javaClass.classLoader.getResourceAsStream(resource)!!
    return StreamUtil.convertSeparators(StreamUtil.readText(BufferedReader(InputStreamReader(stream))))
}