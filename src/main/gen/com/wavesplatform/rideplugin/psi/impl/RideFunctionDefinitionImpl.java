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
import com.wavesplatform.rideplugin.stubs.RideFunctionDefinitionStub;
import com.intellij.psi.stubs.IStubElementType;

public class RideFunctionDefinitionImpl extends RideFunctionDefinitionBaseImpl implements RideFunctionDefinition {

  public RideFunctionDefinitionImpl(@NotNull RideFunctionDefinitionStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public RideFunctionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitFunctionDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getLowerId() {
    return findChildByType(LOWER_ID);
  }

  @Override
  @Nullable
  public PsiElement getUpperId() {
    return findChildByType(UPPER_ID);
  }

}
