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

public class RideTypeImpl extends ASTWrapperPsiElement implements RideType {

  public RideTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideArrayType getArrayType() {
    return PsiTreeUtil.getChildOfType(this, RideArrayType.class);
  }

  @Override
  @Nullable
  public RideSimpleType getSimpleType() {
    return PsiTreeUtil.getChildOfType(this, RideSimpleType.class);
  }

  @Override
  @Nullable
  public RideTupleType getTupleType() {
    return PsiTreeUtil.getChildOfType(this, RideTupleType.class);
  }

  @Override
  @Nullable
  public RideUnionType getUnionType() {
    return PsiTreeUtil.getChildOfType(this, RideUnionType.class);
  }

}
