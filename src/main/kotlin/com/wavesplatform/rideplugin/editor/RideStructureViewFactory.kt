package com.wavesplatform.rideplugin.editor

import com.intellij.ide.structureView.*
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.wavesplatform.rideplugin.RideFile
import com.wavesplatform.rideplugin.icons.RideIcons
import com.wavesplatform.rideplugin.psi.*
import javax.swing.Icon

//show only first level definition
class RideStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return RideModel(psiFile, editor)
            }

            override fun isRootNodeShown(): Boolean {
                return false
            }
        }
    }
}

class RideModel(psiFile: PsiFile, editor: Editor?) :
    StructureViewModelBase(psiFile, RideStructureViewElement(psiFile)), ElementInfoProvider {
    init {
        withSuitableClasses(
            RideFile::class.java,
            RideNamedElement::class.java,
        )
            .withSorters(Sorter.ALPHA_SORTER)

    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is RideSimpleRefExpr
    }
}

class RideStructureViewElement(e: PsiElement) : PsiTreeElementBase<PsiElement?>(e) {
    override fun getPresentableText(): String {
        val currentElement = element
        if (currentElement is RideFile) {
            return "File:" + currentElement.name
        }
        if (currentElement is RideNamedElement) {
            //todo fix due to lack of flexibility
            return "Function:" + currentElement.name
        }
        return "Undefined"
    }

    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        val result: MutableList<StructureViewTreeElement> = arrayListOf()
        val element = element
        if (element is RideFile) {
            val rideAll: RideAll = PsiTreeUtil.findChildOfType(element, RideAll::class.java) ?: return result
            for (next: RideStatement in rideAll.statementList) {
                val child = next.firstChild
                if (child is RideFuncExpr) {
                    child.functionDefinition?.let {
                        result.add(RideStructureViewElement(it))
                    }
                }
            }
        }
        return result
    }

    override fun getIcon(open: Boolean): Icon {
        return RideIcons.FUNCTION
    }
}
