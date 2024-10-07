// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.wavesplatform.rideplugin.psi.*;

public class RideThenBlockImpl extends ASTWrapperPsiElement implements RideThenBlock {

  public RideThenBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitThenBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideBlockState getBlockState() {
    return PsiTreeUtil.getChildOfType(this, RideBlockState.class);
  }

  @Override
  @Nullable
  public RideClosureExpr getClosureExpr() {
    return PsiTreeUtil.getChildOfType(this, RideClosureExpr.class);
  }

  @Override
  @Nullable
  public RideElseBlock getElseBlock() {
    return PsiTreeUtil.getChildOfType(this, RideElseBlock.class);
  }

  @Override
  @NotNull
  public List<RideElseIfBlock> getElseIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RideElseIfBlock.class);
  }

  @Override
  @Nullable
  public RideIfCond getIfCond() {
    return PsiTreeUtil.getChildOfType(this, RideIfCond.class);
  }

}
