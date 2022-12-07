// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;
import com.wavesplatform.rideplugin.psi.mixin.RideVarNameMixin;
import com.wavesplatform.rideplugin.psi.*;

public class RideSimpleRefExprImpl extends RideVarNameMixin implements RideSimpleRefExpr {

  public RideSimpleRefExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitSimpleRefExpr(this);
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
