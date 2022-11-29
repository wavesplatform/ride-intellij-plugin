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

public class RideCallCastChainImpl extends ASTWrapperPsiElement implements RideCallCastChain {

  public RideCallCastChainImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitCallCastChain(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RideFunctionName getFunctionName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideFunctionName.class));
  }

  @Override
  @NotNull
  public RideType getType() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideType.class));
  }

}
