// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RideIfExpr extends RideExpr {

  @Nullable
  RideBlockState getBlockState();

  @Nullable
  RideClosureExpr getClosureExpr();

  @Nullable
  RideElseBlock getElseBlock();

  @NotNull
  List<RideElseIfBlock> getElseIfBlockList();

  @Nullable
  RideIfCond getIfCond();

}
