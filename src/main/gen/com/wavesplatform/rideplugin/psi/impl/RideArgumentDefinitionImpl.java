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

public class RideArgumentDefinitionImpl extends ASTWrapperPsiElement implements RideArgumentDefinition {

  public RideArgumentDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RideVisitor visitor) {
    visitor.visitArgumentDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RideVisitor) accept((RideVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RideArrayElementAtIndex getArrayElementAtIndex() {
    return findChildByClass(RideArrayElementAtIndex.class);
  }

  @Override
  @Nullable
  public RideBaseLiteral getBaseLiteral() {
    return findChildByClass(RideBaseLiteral.class);
  }

  @Override
  @Nullable
  public RideBooleanLiteral getBooleanLiteral() {
    return findChildByClass(RideBooleanLiteral.class);
  }

  @Override
  @Nullable
  public RideIntLiteral getIntLiteral() {
    return findChildByClass(RideIntLiteral.class);
  }

  @Override
  @Nullable
  public RideNumberLiteral getNumberLiteral() {
    return findChildByClass(RideNumberLiteral.class);
  }

  @Override
  @Nullable
  public RideObjectFieldCall getObjectFieldCall() {
    return findChildByClass(RideObjectFieldCall.class);
  }

  @Override
  @Nullable
  public RideStringLiteral getStringLiteral() {
    return findChildByClass(RideStringLiteral.class);
  }

  @Override
  @Nullable
  public RideStructCreation getStructCreation() {
    return findChildByClass(RideStructCreation.class);
  }

  @Override
  @Nullable
  public RideUnitLiteral getUnitLiteral() {
    return findChildByClass(RideUnitLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
