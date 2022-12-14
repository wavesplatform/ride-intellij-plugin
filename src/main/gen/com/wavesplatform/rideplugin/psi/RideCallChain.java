// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideCallChain extends RideCompositeElement {

  @Nullable
  RideCallCastChain getCallCastChain();

  @Nullable
  RideCallFieldChain getCallFieldChain();

  @Nullable
  RideCallFunctionChain getCallFunctionChain();

  @Nullable
  RideCallIndexChain getCallIndexChain();

}
