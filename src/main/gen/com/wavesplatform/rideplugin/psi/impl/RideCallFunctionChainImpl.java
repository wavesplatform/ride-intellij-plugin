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

public class RideCallFunctionChainImpl extends ASTWrapperPsiElement implements RideCallFunctionChain {

  public RideCallFunctionChainImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitCallFunctionChain(this);
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
  @NotNull
  public RideInvokeFunctionName getInvokeFunctionName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideInvokeFunctionName.class));
  }

}
