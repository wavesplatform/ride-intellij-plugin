package com.wavesplatform.rideplugin.editor

import com.intellij.lang.Commenter

class RideCommenter : Commenter {

    override fun getLineCommentPrefix(): String = "#"

    override fun getBlockCommentPrefix(): String = "#"

    override fun getBlockCommentSuffix(): String = "#"

    override fun getCommentedBlockCommentPrefix(): String = "#"

    override fun getCommentedBlockCommentSuffix(): String = "#"
}
