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

public class RideObjectFunctionCallImpl extends ASTWrapperPsiElement implements RideObjectFunctionCall {

  public RideObjectFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitObjectFunctionCall(this);
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
  public List<RideCallChain> getCallChainList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RideCallChain.class);
  }

  @Override
  @NotNull
  public RideFunctionName getFunctionName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideFunctionName.class));
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return notNullChild(findChildByType(IDENT));
  }

}