// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideFieldCall extends RideCompositeElement {

  @NotNull
  List<RideCallFieldChain> getCallFieldChainList();

  @NotNull
  List<RideCallFunctionChain> getCallFunctionChainList();

  @Nullable
  RideStandaloneFunctionCall getStandaloneFunctionCall();

  @Nullable
  RideVarDefinition getVarDefinition();

}
