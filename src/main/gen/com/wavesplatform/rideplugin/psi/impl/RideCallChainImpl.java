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

public class RideCallChainImpl extends ASTWrapperPsiElement implements RideCallChain {

  public RideCallChainImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitCallChain(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideCallCastChain getCallCastChain() {
    return PsiTreeUtil.getChildOfType(this, RideCallCastChain.class);
  }

  @Override
  @Nullable
  public RideCallFieldChain getCallFieldChain() {
    return PsiTreeUtil.getChildOfType(this, RideCallFieldChain.class);
  }

  @Override
  @Nullable
  public RideCallFunctionChain getCallFunctionChain() {
    return PsiTreeUtil.getChildOfType(this, RideCallFunctionChain.class);
  }

  @Override
  @Nullable
  public RideCallIndexChain getCallIndexChain() {
    return PsiTreeUtil.getChildOfType(this, RideCallIndexChain.class);
  }

}
