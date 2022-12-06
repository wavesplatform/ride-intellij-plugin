package com.wavesplatform.rideplugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.usageView.UsageViewUtil
import com.wavesplatform.rideplugin.psi.RideCompositeElement
import javax.swing.Icon

open class RideCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), RideCompositeElement {
    override fun toString(): String {
        return node.elementType.toString()
    }

    override fun getPresentation(): ItemPresentation {
        val text = UsageViewUtil.createNodeText(this)
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return text
            }

            override fun getLocationString(): String {
                return containingFile.name
            }

            override fun getIcon(b: Boolean): Icon? {
                return null
            }
        }
    }
}
