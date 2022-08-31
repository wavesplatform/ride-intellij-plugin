// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideStatement extends PsiElement {

  @Nullable
  RideArrayDefinition getArrayDefinition();

  @Nullable
  RideFunctionInvocation getFunctionInvocation();

  @Nullable
  RideLetDefinition getLetDefinition();

  @Nullable
  PsiElement getComment();

}
