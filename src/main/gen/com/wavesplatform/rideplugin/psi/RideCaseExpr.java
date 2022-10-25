// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideCaseExpr extends RideExpr {

  @Nullable
  RideArrayType getArrayType();

  @Nullable
  RideSimpleType getSimpleType();

  @NotNull
  List<RideStatement> getStatementList();

  @Nullable
  RideTupleType getTupleType();

  @Nullable
  RideUnionType getUnionType();

  @Nullable
  PsiElement getIdent();

}
