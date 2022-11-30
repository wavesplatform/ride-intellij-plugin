package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.wavesplatform.rideplugin.RideIcons
import com.wavesplatform.rideplugin.loadCodeSampleResource
import javax.swing.Icon


class RideColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return RideIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return RideSyntaxHighlighter()
    }

    override fun getDemoText(): String = loadCodeSampleResource(this, "sample/highlighter_example.ride")

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return mapOf(
            "Directive" to RideSyntaxHighlighter.DIRECTIVE,
            "Function" to RideSyntaxHighlighter.FUNCTION,
            "Type" to RideSyntaxHighlighter.TYPE,
            "Annotation" to RideSyntaxHighlighter.ANNOTATION
        )
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
            AttributesDescriptor("Keyword", RideSyntaxHighlighter.KEYWORDS),
            AttributesDescriptor("Number", RideSyntaxHighlighter.NUMBER),
            AttributesDescriptor("String", RideSyntaxHighlighter.STRING),
            AttributesDescriptor("Brackets", RideSyntaxHighlighter.BRACKETS),
            AttributesDescriptor("Operator", RideSyntaxHighlighter.OPERATORS),
            AttributesDescriptor("Bad value", RideSyntaxHighlighter.BAD_CHARACTER),
            AttributesDescriptor("Identifier", RideSyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Directive", RideSyntaxHighlighter.DIRECTIVE),
            AttributesDescriptor("Annotation", RideSyntaxHighlighter.ANNOTATION),
            AttributesDescriptor("Function", RideSyntaxHighlighter.FUNCTION),
            AttributesDescriptor("Type", RideSyntaxHighlighter.TYPE),
        )
    }
}