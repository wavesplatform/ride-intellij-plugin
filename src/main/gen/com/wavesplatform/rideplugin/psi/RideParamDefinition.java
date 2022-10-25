// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideParamDefinition extends RideCompositeElement {

  @Nullable
  RideArrayType getArrayType();

  @Nullable
  RideSimpleType getSimpleType();

  @Nullable
  RideTupleType getTupleType();

  @Nullable
  RideUnionType getUnionType();

  @NotNull
  RideVarDefinition getVarDefinition();

}
