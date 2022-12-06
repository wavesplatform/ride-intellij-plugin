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

public class RideElseIfBlockImpl extends ASTWrapperPsiElement implements RideElseIfBlock {

  public RideElseIfBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitElseIfBlock(this);
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
  @NotNull
  public RideIfCond getIfCond() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideIfCond.class));
  }

}
