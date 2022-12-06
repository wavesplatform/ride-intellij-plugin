// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideFuncExpr extends RideExpr {

  @Nullable
  RideClosure getClosure();

  @NotNull
  List<RideExpr> getExprList();

  @Nullable
  RideFunctionDefinition getFunctionDefinition();

  @Nullable
  RideParamGroup getParamGroup();

}
