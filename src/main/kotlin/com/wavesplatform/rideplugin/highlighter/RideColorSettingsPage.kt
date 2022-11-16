package com.wavesplatform.rideplugin.highlighter

import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.wavesplatform.rideplugin.RideIcons
import javax.swing.Icon


class RideColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return RideIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return RideSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """
        {-# SCRIPT_TYPE  ACCOUNT #-}
        {-# CONTENT_TYPE LIBRARY #-}
        {-# STDLIB_VERSION 5 #-}

        # hm
        # another
        let a = 42                 # Integer variable definition
        let b = "Ride the Waves!"  # String variable definition
        let bool = true  # Boolean variable definition

        @Callable(i)
        func lazyIsGood() = {
          let a = base58'AAAAA'
          strict balanceBefore = wavesBalance(this).value().regular
          strict result = invoke(
            dApp2,
            "bar",
            args,
            [AttachedPayment(unit,100000000)]
          )
          strict balanceAfter = wavesBalance(this).regular
          let c = {
             strict d = 1
             true
            }
          c
        }

        func reward() = {
           let p = value(i.payments[0])
           if p.assetId != lpTokenId {
            true
           } else {
            false
           }
           if p.assetId > lpTokenId
              then throw("Incorrect payment")
              else {
                 let lpQty = assetInfo(lpTokenId).value().quantity
                 let rewardQty = assetInfo(rewardTokenId).value().quantity
                 let share = fraction(p.amount,rewardQty,lpQty)
                 strict result = invoke(this, "burn", [p.amount], [1])
                 [
                    ScriptTransfer(i.caller, share, rewardTokenId)
                 ]
              }
        }

        let list = [1, 2, 3]
        let a1 = list.size()
        let a2 = size(list)

        let b1 = getInteger(this, "key")
        let b2 = this.getInteger("key")

        func say() = {
          "Hello world!"
        }

        func main(amount: Int) = {
           if (amount > 0)
           then
                "Done!"
           else
                throw("Error!")
        }

        let someConstant = 42
        func doSomething() = {
            1 + 1
        }

        func main(amount: Int, assetId: ByteVector|Unit, names: List[String]) = {
           throw("Error")
        }

        match tx {
            case ex: ExchangeTransaction|MassTransferTransaction =>
                let pair = AssetPair(assetId, unit)
                let rate = extract(getInteger(issuer, "exchangeRate"))
                let rateDiff = rate - fraction(100000000, ex.price, ex.amount)
                ex.buyOrder.assetPair == pair && rateDiff > -100 && rateDiff < 100
            case _ => {true}
        }

        match tx {
            case t: TransferTransaction|ExchangeTransaction|MassTransferTransaction|Order => false   # deny any transfer of funds from the account
            case _: Transaction => sigVerify(tx.bodyBytes, tx.proofs[0], tx.senderPublicKey) # allow all other known transaction types if the signature is correct
            case _ => {false}  # deny any other (new, unknown) entity type since they are not supported in the Ride version used
        }

        func sum(accum: Int, next: Int) = accum
        let arr = [1,2,3,4,5]
        FOLD<5>(arr, 0, sum)    # Result: 15

        func mult(accum: Int, next: Int) = { accum }
        let arr = [
            1,
            2,
            3,
            4,
            5
        ]
        FOLD<5>(arr, 1, mult)    # Result: 120

        func filterEven(accum: List[Int|String], next: Int) = {
           if (next % 2 == 0) then accum :+ next else accum
        }

        let arr = [1,2,3,4,5]
        FOLD<5>(arr, [], filterEven)    # Result: [2, 4]

        func map(accum: List[Int], next: Int) = (next - 1) :: accum
        let arr = [1, 2, 3, 4, 5]
        FOLD<5>(arr, [], map)    # Result: [4, 3, 2, 1, 0]

        let keys = ["key1", "key2", "key3"]
        let values = ["value1", "value2", "value3"]

        func addStringEntry(accum: (List[StringEntry], Int), nextValue: String) =
           {    #comment
              let (result, j) = accum
              (result :+ StringEntry(keys[j], nextValue), j + 1)
           }
        let r = FOLD<10>(values, ([], 0), addStringEntry)
        r._1

        wavesBalance(Address(base58'3Mz9N7YPfZPWGd4yYaX6H53Gcgrq6ifYiH7'))
        wavesBalance(Alias("merry"))                # The result is the same

        let addr = Address(base58'3N4iKL6ikwxiL7yNvWQmw7rg3wGna8uL6LU')
        getInteger(addr,"integerVal")               # Returns 1
        getInteger(addr,"noKey")                    # Returns unit

        size(getString("key"))

        size(getStringValue("key"))
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return mapOf(
            "Directive" to RideSyntaxHighlighter.DIRECTIVE,
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
        )
    }
}