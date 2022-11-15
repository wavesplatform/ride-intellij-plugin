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

public class RideIndexExprImpl extends RideExprImpl implements RideIndexExpr {

  public RideIndexExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitIndexExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RideExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RideExpr.class);
  }

  @Override
  @Nullable
  public RideFieldCall getFieldCall() {
    return PsiTreeUtil.getChildOfType(this, RideFieldCall.class);
  }

  @Override
  @Nullable
  public RideObjectFunctionCall getObjectFunctionCall() {
    return PsiTreeUtil.getChildOfType(this, RideObjectFunctionCall.class);
  }

  @Override
  @Nullable
  public RideStandaloneFunctionCall getStandaloneFunctionCall() {
    return PsiTreeUtil.getChildOfType(this, RideStandaloneFunctionCall.class);
  }

  @Override
  @Nullable
  public PsiElement getIdent() {
    return findChildByType(IDENT);
  }

}
