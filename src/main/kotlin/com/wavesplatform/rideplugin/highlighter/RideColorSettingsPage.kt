package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.wavesplatform.rideplugin.RideIcons
import java.util.regex.Pattern
import javax.swing.Icon


class RideColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return RideIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return RideSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """# You are reading the ".properties" entry.
                ! The exclamation mark can also mark text as comments.
                website = https://en.wikipedia.org/
                language = English
                # The backslash below tells the application to continue reading
                # the value onto the next line.
                message = Welcome to \
                Wikipedia!
                # Add spaces to the key
                key\ with\ spaces = This is the value that could be looked up with the key "key with spaces".
                # Unicode
                tab : \u0009""".trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Ride"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Key", RideSyntaxHighlighter.KEY),
            AttributesDescriptor("Separator", RideSyntaxHighlighter.SEPARATOR),
            AttributesDescriptor("Value", RideSyntaxHighlighter.VALUE),
            AttributesDescriptor("Bad value", RideSyntaxHighlighter.BAD_CHARACTER)
        )
    }
}