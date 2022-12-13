// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideObjectFunctionCall extends RideExpr {

  @NotNull
  RideCallArguments getCallArguments();

  @NotNull
  RideCallingObject getCallingObject();

  @NotNull
  RideInvokeFunctionName getInvokeFunctionName();

}
