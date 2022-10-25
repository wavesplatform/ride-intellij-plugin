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

public class RideLiteralExprImpl extends RideExprImpl implements RideLiteralExpr {

  public RideLiteralExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitLiteralExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideBoolLiteral getBoolLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideBoolLiteral.class);
  }

  @Override
  @Nullable
  public RideByteVectorLiteral getByteVectorLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideByteVectorLiteral.class);
  }

  @Override
  @Nullable
  public RideNilLiteral getNilLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideNilLiteral.class);
  }

  @Override
  @Nullable
  public RideNumericLiteral getNumericLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideNumericLiteral.class);
  }

  @Override
  @Nullable
  public RideStringLiteral getStringLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideStringLiteral.class);
  }

  @Override
  @Nullable
  public RideUnitLiteral getUnitLiteral() {
    return PsiTreeUtil.getChildOfType(this, RideUnitLiteral.class);
  }

}
