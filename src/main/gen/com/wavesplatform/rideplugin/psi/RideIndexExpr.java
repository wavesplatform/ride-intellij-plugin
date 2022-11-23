// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideIndexExpr extends RideExpr {

  @NotNull
  List<RideExpr> getExprList();

  @Nullable
  RideFieldCall getFieldCall();

  @Nullable
  RideObjectFunctionCall getObjectFunctionCall();

  @Nullable
  RideStandaloneFunctionCall getStandaloneFunctionCall();

  @Nullable
  PsiElement getLowerId();

}
