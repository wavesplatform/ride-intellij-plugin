// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideCallExpr extends RideExpr {

  @Nullable
  RideFieldCall getFieldCall();

  @Nullable
  RideFunctionCall getFunctionCall();

  @Nullable
  RideStructCall getStructCall();

}
