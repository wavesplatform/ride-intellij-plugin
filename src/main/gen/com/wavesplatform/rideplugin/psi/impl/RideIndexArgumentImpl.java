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

public class RideIndexArgumentImpl extends ASTWrapperPsiElement implements RideIndexArgument {

  public RideIndexArgumentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitIndexArgument(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RideArgument getArgument() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RideArgument.class));
  }

}
