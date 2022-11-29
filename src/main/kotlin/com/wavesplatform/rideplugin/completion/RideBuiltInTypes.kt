package com.wavesplatform.rideplugin.completion

fun baseTypes() = hashSetOf(
    "Any",
    "BigInt",
    "Boolean",
    "ByteVector",
    "Int",
    "String",
    "Unit",
    "List",
    "Tuple",
    "Union"
)

fun scriptActionStructs() = hashSetOf(
    "BinaryEntry",
    "BooleanEntry",
    "Burn",
    "DeleteEntry",
    "IntegerEntry",
    "Issue",
    "Lease",
    "LeaseCancel",
    "Reissue",
    "ScriptTransfer",
    "SponsorFee",
    "StringEntry"
)

fun commonStructs() = hashSetOf(
    "Address",
    "Alias",
    "Asset",
    "AssetPair",
    "AttachedPayment",
    "BalanceDetails",
    "BlockInfo",
    "Invocation",
    "Order",
    "Transfer"
)

fun transactionStructs() = hashSetOf(
    "BurnTransaction",
    "CreateAliasTransaction",
    "DataTransaction",
    "ExchangeTransaction",
    "GenesisTransaction",
    "InvokeScriptTransaction",
    "IssueTransaction",
    "LeaseCancelTransaction",
    "LeaseTransaction",
    "MassTransferTransaction",
    "ReissueTransaction",
    "SetAssetScriptTransaction",
    "SetScriptTransaction",
    "SponsorFeeTransaction",
    "TransferTransaction",
    "UpdateAssetInfoTransaction"
)