package com.wavesplatform.rideplugin.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.util.elementType
import com.wavesplatform.rideplugin.RideLanguage
import com.wavesplatform.rideplugin.psi.RideTypes


class RideFormattingModelBuilder : FormattingModelBuilder {
    companion object {
        private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, RideLanguage.INSTANCE)
                .before(RideTypes.COMMA).spaceIf(false)
                .after(RideTypes.COMMA).spaceIf(true)
                .after(RideTypes.LET).spaces(1)
                //.around(RideTypes.ASSIGN).spaces(1)
                .around(RideTypes.PLUS).spaces(1)
                //.around(RideTypes.MINUS).spaces(1)
                .around(RideTypes.ASTERISK).spaces(1)
                .around(RideTypes.SLASH).spaces(1)
                .around(RideTypes.PARAM_GROUP).none()
                .after(RideTypes.LBRACE).lineBreakInCode()
                .around(RideTypes.RBRACE).lineBreakInCode()
                .before(RideTypes.FUNCTION).spaceIf(false)
                .after(RideTypes.FUNCTION).spaceIf(true)
                .around(RideTypes.CASE).spaces(1)
                .before(RideTypes.LBRACE).spaces(1)
                .after(RideTypes.COLON).spaces(1)
                .around(RideTypes.ARROW).spaces(1)
                .around(RideTypes.THEN).spaces(1)
                .around(RideTypes.ELSE).spaces(1)
        }
    }

    override fun createModel(context: FormattingContext): FormattingModel {
        val node = context.node
        val settings = context.codeStyleSettings
        val block: Block = RideFormattingBlock(
            myNode = node,
            myAlignment = null,
            myIndent = Indent.getNoneIndent(),
            myWrap = null,
            mySettings = settings,
            mySpacingBuilder = createSpacingBuilder(settings)
        )

        return FormattingModelProvider.createFormattingModelForPsiFile(
            context.containingFile, block, settings
        )
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }

    private class RideFormattingBlock(
        val myNode: ASTNode,
        myAlignment: Alignment?,
        private val myIndent: Indent?,
        myWrap: Wrap?,
        private val mySettings: CodeStyleSettings,
        private val mySpacingBuilder: SpacingBuilder
    ) : AbstractBlock(myNode, myWrap, myAlignment) {

        override fun getIndent(): Indent? {
            return myIndent
        }

        override fun getAlignment(): Alignment? {
            return myAlignment
        }

        override fun getChildIndent(): Indent? {
            return when (myNode.psi.elementType) {
                RideTypes.MATCHING_CLOSURE,
                RideTypes.CASE_CLOSURE,

                RideTypes.FUNC_EXPR,
                RideTypes.IF_EXPR,
                RideTypes.ELSE_BLOCK,
                RideTypes.PATTERN_MATCHING_EXPR,
                RideTypes.CASE_EXPR,
                RideTypes.CLOSURE_EXPR,
                    //RideTypes.INDEX_EXPR,
                    //RideTypes.TUPLE_EXPR,
                    //RideTypes.ARRAY_EXPR,
                    //RideTypes.COMMENT,
                    //RideTypes.PARAM_GROUP,
                    //RideTypes.CALL_ARGUMENTS,
                    //RideTypes.ARGUMENTS,
                RideTypes.CALL_ARGUMENTS,
                RideTypes.ARRAY_CALL_ARGUMENTS,
                    //RideTypes.COMMENT
                -> Indent.getNormalIndent(false)

                //RideTypes.CALL_ARGUMENTS -> Indent.getNormalIndent(false)

                else -> Indent.getNoneIndent()
            }
        }

        private fun calcIndent(child: ASTNode): Indent {
            return when (child.elementType) {
                RideTypes.BLOCK_STATE,
                RideTypes.CASE_EXPR,
                RideTypes.PARAM_GROUP,
                    //RideTypes.PATTERN_MATCHING_EXPR,
                    //RideTypes.ARGUMENTS,
                    //RideTypes.COMMENT,
                    //RideTypes.INDEX_EXPR,
                    //RideTypes.STRUCT_CALL,
                RideTypes.ARGUMENTS,
                    //RideTypes.COMMENT
                    //RideTypes.ARRAY_EXPR,
                    //RideTypes.CALL_INDEX_CHAIN
                    //RideTypes.CALL_ARGUMENTS
                -> Indent.getNormalIndent(false)

                //RideTypes.CALL_ARGUMENTS,
                //RideTypes.ARRAY_CALL_ARGUMENTS -> Indent.getNormalIndent(true)
                RideTypes.INDEX_ARGUMENT -> Indent.getNormalIndent(false)

                else -> Indent.getNoneIndent()
            }
        }

        override fun getSpacing(child1: Block?, child2: Block): Spacing? {
            return mySpacingBuilder.getSpacing(this, child1, child2)
        }

        override fun isLeaf(): Boolean {
            return myNode.firstChildNode == null
        }

        override fun buildChildren(): MutableList<Block> {
            val blocks: MutableList<Block> = arrayListOf()
            var child = myNode.firstChildNode
            while (child != null) {
                val childType = child.elementType
                if (child.textRange.length == 0) {
                    child = child.treeNext
                    continue
                }
                if (childType == TokenType.WHITE_SPACE || childType == RideTypes.NEW_LINE) {
                    child = child.treeNext
                    continue
                }
                val indent = calcIndent(child)
                val e = RideFormattingBlock(child, null, indent, null, mySettings, mySpacingBuilder)
                blocks.add(e)
                child = child.treeNext
            }
            return blocks
        }
    }
}
