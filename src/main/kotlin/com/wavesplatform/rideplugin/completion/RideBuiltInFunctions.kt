package com.wavesplatform.rideplugin.completion

fun mathematicalFunctions() = hashSetOf(
    "fraction",
    "log",
    "median",
    "pow",
    "sqrt"
)

fun blockchainFunctions() = hashSetOf(
    "addressFromRecipient",
    "assetBalance",
    "assetInfo",
    "blockInfoByHeight",
    "calculateAssetId",
    "calculateLeaseId",
    "scriptHash",
    "transactionHeightById",
    "transferTransactionById",
    "wavesBalance"
)

fun verificationFunctions() = hashSetOf(
    "bn256Groth16Verify",
    "createMerkleRoot",
    "ecrecover",
    "groth16Verify",
    "rsaVerify",
    "sigVerify"
)

fun dAppFunctions() = hashSetOf(
    "invoke",
    "reentrantInvoke"
)

fun decodeFunctions() = hashSetOf(
    "addressFromString",
    "fromBase16String",
    "fromBase58String",
    "fromBase64String",
)

fun exceptionFunctions() = hashSetOf(
    "throw"
)

fun encodeFunctions() = hashSetOf(
    "toBase16String",
    "toBase58String",
    "toBase64String",
)

fun convertFunctions() = hashSetOf(
    "addressFromPublicKey",
    "parseBigInt",
    "parseBigIntValue",
    "parseInt",
    "parseIntValue",
    "toBigInt",
    "toBytes",
    "toInt",
    "toString",
    "toUtf8String",
    "transferTransactionFromProto"
)

fun byteVectorFunctions() = hashSetOf(
    "drop",
    "dropRight",
    "size",
    "take",
    "takeRight"
)

fun unionFunctions() = hashSetOf(
    "isDefined",
    "value",
    "valueOrElse",
    "valueOrErrorMessage"
)

fun accountDataFunctions() = hashSetOf(
    "getBinary",
    "getBinaryValue",
    "getBoolean",
    "getBooleanValue",
    "getInteger",
    "getIntegerValue",
    "getString",
    "getStringValue",
    "isDataStorageUntouched"
)

fun listFunctions() = hashSetOf(
    "cons",
    "containsElement",
    "getElement",
    "indexOf",
    "lastIndexOf",
    "max",
    "min",
    "removeByIndex",
    "size"
)

fun stringFunctions() = hashSetOf(
    "contains",
    "drop",
    "dropRight",
    "indexOf",
    "lastIndexOf",
    "makeString",
    "size",
    "split",
    "take",
    "takeRight"
)

fun transactionFunctions() = hashSetOf(
    "getBinary",
    "getBinaryValue",
    "getBoolean",
    "getBooleanValue",
    "getInteger",
    "getIntegerValue",
    "getString",
    "getStringValue"
)

fun hashFunctions() = hashSetOf(
    "blake2b256",
    "keccak256",
    "sha256"
)

