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

public class RideVarDeclarationStatementImpl extends ASTWrapperPsiElement implements RideVarDeclarationStatement {

  public RideVarDeclarationStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitVarDeclarationStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideClosure getClosure() {
    return PsiTreeUtil.getChildOfType(this, RideClosure.class);
  }

  @Override
  @Nullable
  public RideExpr getExpr() {
    return PsiTreeUtil.getChildOfType(this, RideExpr.class);
  }

  @Override
  @Nullable
  public RideTupleDefinition getTupleDefinition() {
    return PsiTreeUtil.getChildOfType(this, RideTupleDefinition.class);
  }

  @Override
  @Nullable
  public RideVarDefinition getVarDefinition() {
    return PsiTreeUtil.getChildOfType(this, RideVarDefinition.class);
  }

}
