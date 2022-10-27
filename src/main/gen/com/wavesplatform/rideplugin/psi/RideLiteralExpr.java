// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideLiteralExpr extends RideExpr {

  @Nullable
  RideBoolLiteral getBoolLiteral();

  @Nullable
  RideByteVectorLiteral getByteVectorLiteral();

  @Nullable
  RideNilLiteral getNilLiteral();

  @Nullable
  RideNumericLiteral getNumericLiteral();

  @Nullable
  RideStringLiteral getStringLiteral();

  @Nullable
  RideUnitLiteral getUnitLiteral();

}
