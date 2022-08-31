// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideArgumentDefinition extends PsiElement {

  @Nullable
  RideArrayElementAtIndex getArrayElementAtIndex();

  @Nullable
  RideBaseLiteral getBaseLiteral();

  @Nullable
  RideBooleanLiteral getBooleanLiteral();

  @Nullable
  RideIntLiteral getIntLiteral();

  @Nullable
  RideNumberLiteral getNumberLiteral();

  @Nullable
  RideObjectFieldCall getObjectFieldCall();

  @Nullable
  RideStringLiteral getStringLiteral();

  @Nullable
  RideStructCreation getStructCreation();

  @Nullable
  RideUnitLiteral getUnitLiteral();

  @Nullable
  PsiElement getIdentifier();

}
