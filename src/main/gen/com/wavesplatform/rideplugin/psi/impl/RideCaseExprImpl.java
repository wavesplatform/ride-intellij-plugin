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

public class RideCaseExprImpl extends RideExprImpl implements RideCaseExpr {

  public RideCaseExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitCaseExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideCaseClosure getCaseClosure() {
    return PsiTreeUtil.getChildOfType(this, RideCaseClosure.class);
  }

  @Override
  @Nullable
  public RideLiteralExpr getLiteralExpr() {
    return PsiTreeUtil.getChildOfType(this, RideLiteralExpr.class);
  }

  @Override
  @Nullable
  public RideTypeDefinition getTypeDefinition() {
    return PsiTreeUtil.getChildOfType(this, RideTypeDefinition.class);
  }

  @Override
  @Nullable
  public RideVarDefinition getVarDefinition() {
    return PsiTreeUtil.getChildOfType(this, RideVarDefinition.class);
  }

}
