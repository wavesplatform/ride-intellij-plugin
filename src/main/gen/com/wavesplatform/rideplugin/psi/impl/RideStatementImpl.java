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

public class RideStatementImpl extends ASTWrapperPsiElement implements RideStatement {

  public RideStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideArrayDefinition getArrayDefinition() {
    return findChildByClass(RideArrayDefinition.class);
  }

  @Override
  @Nullable
  public RideFunctionInvocation getFunctionInvocation() {
    return findChildByClass(RideFunctionInvocation.class);
  }

  @Override
  @Nullable
  public RideLetDefinition getLetDefinition() {
    return findChildByClass(RideLetDefinition.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
