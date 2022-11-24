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

public class RideArrayExprImpl extends RideExprImpl implements RideArrayExpr {

  public RideArrayExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitArrayExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideArguments getArguments() {
    return PsiTreeUtil.getChildOfType(this, RideArguments.class);
  }

  @Override
  @Nullable
  public RideCallChain getCallChain() {
    return PsiTreeUtil.getChildOfType(this, RideCallChain.class);
  }

}
