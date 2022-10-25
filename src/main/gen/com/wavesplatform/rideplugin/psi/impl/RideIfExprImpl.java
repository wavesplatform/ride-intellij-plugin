// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;
import com.wavesplatform.rideplugin.psi.*;

public class RideIfExprImpl extends RideExprImpl implements RideIfExpr {

  public RideIfExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitIfExpr(this);
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
  public RideElseBlock getElseBlock() {
    return PsiTreeUtil.getChildOfType(this, RideElseBlock.class);
  }

  @Override
  @Nullable
  public RideExpr getExpr() {
    return PsiTreeUtil.getChildOfType(this, RideExpr.class);
  }

  @Override
  @Nullable
  public RideIfCond getIfCond() {
    return PsiTreeUtil.getChildOfType(this, RideIfCond.class);
  }

}
