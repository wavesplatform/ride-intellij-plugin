// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideLetDefinition extends PsiElement {

  @Nullable
  RideFunctionInvocation getFunctionInvocation();

  @Nullable
  RideMethodInvocation getMethodInvocation();

  @Nullable
  RideStructCreation getStructCreation();

  @NotNull
  PsiElement getIdentifier();

}
