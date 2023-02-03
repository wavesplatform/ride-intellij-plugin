package com.wavesplatform.rideplugin

import com.wavesplatform.lang.Lang
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun compileCorrectCodeTest() {
        val compileDAPP = kotlin.runCatching {
            Lang.compileDApp(correctScript)
        }.onFailure {
            println("#### ${it.message}")
        }
        Assert.assertTrue(compileDAPP.isSuccess)
    }

    @Test
    fun compileIncorrectCodeTest() {
        val compileDAPP = kotlin.runCatching {
            Lang.compileDApp(incorrectScript)
        }.onFailure {
            println("#### ${it.message}")
        }

        Assert.assertTrue(compileDAPP.isFailure)
    }

    private val incorrectScript = """
            {-# STDLIB_VERSION 6 #-}
            {-# CONTENT_TYPE DAPP #-}
            {-# SCRIPT_TYPE ACCOUNT #-}

            func calculate() = a + b
            
        """.trimIndent()

    private val correctScript = """
            {-# STDLIB_VERSION 6 #-}
            {-# CONTENT_TYPE DAPP #-}
            {-# SCRIPT_TYPE ACCOUNT #-}

            let kCommon = "common"
            let kRare = "rare"
            let kLegendary = "legendary"
            let kPrice = "priceLever"
            let separator = "|"
            let countRare =  getInteger(this, kRare).valueOrElse(0)
            let countCommon =  getInteger(this, kCommon).valueOrElse(0)
            let countLegendary = getInteger(this, kLegendary).valueOrElse(0)
            let correctPrice = getIntegerValue(this, kPrice)


            func randomize(bytes: ByteVector, range: Int) = {
              let hash = sha256(bytes)
              let index = toInt(hash)
              index % range
            }

            func incrementCounter(rare: String) = {
              if (rare==kCommon) then
                IntegerEntry(kCommon, countCommon + 1)
              else if (rare==kRare) then 
                IntegerEntry(kRare, countCommon + 1)
              else 
                IntegerEntry(kLegendary, countLegendary + 1)
            }

            func calculateRarity(transactionId: ByteVector) = {
              let tokenRare = randomize(transactionId, 100)
              if(tokenRare<=5) then 
                kLegendary
              else if (tokenRare>=80) then 
                kRare
              else
                kCommon
            }

            @Callable(i)
            func issueNft(name: String, desc: String, rarity: String, prefix: String) = {
              if (i.caller != this) then
                throw("Only owner")
              else {
                let newToken = Issue(name, desc, 1, 0, false)
                let issueId = calculateAssetId(newToken)
                [
                  newToken,
                  StringEntry(rarity + separator + prefix, issueId.toBase58String())  
                ]
              }
            }

            @Callable(i)
            func setPrice(price: Int) = {
              if (i.caller != this) then
                throw("Only owner")
              else
              [
                IntegerEntry(kPrice, price)
              ]
            }

            @Callable(i)
            func pullTheLever() = {
              let amount = i.payments[0].amount.value()
              if (i.payments[0].assetId != unit) then
                throw("Pay in waves")
                else {
                if (amount<correctPrice) then 
                  throw("Payment amount < " + correctPrice.toString())
                  else {
                  let rarity = calculateRarity(i.transactionId)
                  let incrementStruct = incrementCounter(rarity)
                  let tokenKey = rarity + separator + toString(getInteger(this, rarity).valueOrElse(0)) 
                  let assetKey = getString(this, tokenKey).valueOrErrorMessage(tokenKey)
                    [
                      incrementStruct,
                      ScriptTransfer(i.caller, 1, assetKey.fromBase58String()),
                      StringEntry(i.caller.toString() + tokenKey, assetKey)
                    ]  
                }
              }
            }
        """.trimIndent()
}