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

public class RideFunctionCallImpl extends ASTWrapperPsiElement implements RideFunctionCall {

  public RideFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
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

}
