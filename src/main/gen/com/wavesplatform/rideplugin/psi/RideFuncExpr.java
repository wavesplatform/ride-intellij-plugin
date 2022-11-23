// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideFuncExpr extends RideExpr {

  @Nullable
  RideAnnotationExpr getAnnotationExpr();

  @Nullable
  RideClosure getClosure();

  @Nullable
  RideFunctionName getFunctionName();

  @Nullable
  RideParamGroup getParamGroup();

}
