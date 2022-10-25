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
        return """{-# STDLIB_VERSION 3 #-}
                  {-# CONTENT_TYPE DAPP #-}
                  {-# SCRIPT_TYPE ACCOUNT #-}
                  
                  #
                  # Waves dApp version of famous Magic 8 ball toy!
                  # Function name: tellme(question: String)
                  # Question and answer will be written to dApp data state
                  #
                  # Example on Testnet: 3N27HUMt4ddx2X7foQwZRmpFzg5PSzLrUgU
                  #
                  
                  let answersCount = 20
                  let answers = 
                      ["It is certain.",
                      "It is decidedly so.",
                      "Without a doubt.",
                      "Yes - definitely.",
                      "You may rely on it.",
                      "As I see it, yes.",
                      "Most likely.",
                      "Outlook good.",
                      "Yes.",
                      "Signs point to yes.",
                      "Reply hazy, try again.",
                      "Ask again later.",
                      "Better not tell you now.",
                      "Cannot predict now.",
                      "Concentrate and ask again.",
                      "Don't count on it.",
                      "My reply is no.",
                      "My sources say no.",
                      "Outlook not so good.",
                      "Very doubtful."]
                  
                  
                  #
                  # Simple pseudorandom answer generator
                  #
                  func getAnswer(question: String, previousAnswer: String) = {
                      let hash = sha256(toBytes(question + previousAnswer))
                      let index = toInt(hash)
                      #answers[index % answersCount]
                  }
                  
                  func getPreviousAnswer(address: String) = {
                    match getString(this, address + "_a") {
                      case a: String => a
                      case _ => address
                    }
                  }
                  
                  @Callable(i)
                  func tellme(question: String) = {
                      let callerAddress = toBase58String(i.caller.bytes)
                      let answer = getAnswer(question, getPreviousAnswer(callerAddress))
                  
                      WriteSet([
                          DataEntry(callerAddress + "_q", question),
                          DataEntry(callerAddress + "_a", answer)
                          ])
                  }""".trimIndent()
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
            AttributesDescriptor("Bad value", RideSyntaxHighlighter.BAD_CHARACTER),
            AttributesDescriptor("Directive", RideSyntaxHighlighter.DIRECTIVE),
            AttributesDescriptor("Annotation", RideSyntaxHighlighter.ANNOTATION)
        )
    }
}