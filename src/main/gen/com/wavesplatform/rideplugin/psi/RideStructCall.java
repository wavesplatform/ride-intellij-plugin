// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideStructCall extends RideCompositeElement {

  @Nullable
  RideArguments getArguments();

  @NotNull
  List<RideCallChain> getCallChainList();

  @NotNull
  RideType getType();

}
