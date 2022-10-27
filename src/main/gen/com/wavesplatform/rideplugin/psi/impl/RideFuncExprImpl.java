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

public class RideFuncExprImpl extends RideExprImpl implements RideFuncExpr {

  public RideFuncExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitFuncExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideAnnotation getAnnotation() {
    return PsiTreeUtil.getChildOfType(this, RideAnnotation.class);
  }

  @Override
  @Nullable
  public RideBlockState getBlockState() {
    return PsiTreeUtil.getChildOfType(this, RideBlockState.class);
  }

  @Override
  @Nullable
  public RideParamGroup getParamGroup() {
    return PsiTreeUtil.getChildOfType(this, RideParamGroup.class);
  }

  @Override
  @Nullable
  public PsiElement getIdent() {
    return findChildByType(IDENT);
  }

}
