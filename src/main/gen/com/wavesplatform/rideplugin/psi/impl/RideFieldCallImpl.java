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

public class RideFieldCallImpl extends RideExprImpl implements RideFieldCall {

  public RideFieldCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitFieldCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RideCallFieldChain> getCallFieldChainList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RideCallFieldChain.class);
  }

  @Override
  @NotNull
  public List<RideCallFunctionChain> getCallFunctionChainList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RideCallFunctionChain.class);
  }

  @Override
  @Nullable
  public RideStandaloneFunctionCall getStandaloneFunctionCall() {
    return PsiTreeUtil.getChildOfType(this, RideStandaloneFunctionCall.class);
  }

  @Override
  @Nullable
  public RideVarDefinition getVarDefinition() {
    return PsiTreeUtil.getChildOfType(this, RideVarDefinition.class);
  }

}
