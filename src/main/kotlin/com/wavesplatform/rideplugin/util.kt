package com.wavesplatform.rideplugin

import com.intellij.openapi.util.io.StreamUtil
import java.io.BufferedReader
import java.io.InputStreamReader

fun loadCodeSampleResource(ctx: Any, resource: String): String {
    val stream = ctx.javaClass.classLoader.getResourceAsStream(resource)!!
    // We need to convert line separators here, because IntelliJ always expects \n,
    // while on Windows the resource file will be read with \r\n as line separator.
    return StreamUtil.convertSeparators(StreamUtil.readText(BufferedReader(InputStreamReader(stream))))
}