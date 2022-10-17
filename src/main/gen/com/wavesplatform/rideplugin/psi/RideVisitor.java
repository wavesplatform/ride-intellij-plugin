// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;

public class RideVisitor extends PsiElementVisitor {

  public void visitAll(@NotNull RideAll o) {
    visitCompositeElement(o);
  }

  public void visitArgument(@NotNull RideArgument o) {
    visitCompositeElement(o);
  }

  public void visitArguments(@NotNull RideArguments o) {
    visitCompositeElement(o);
  }

  public void visitCallArguments(@NotNull RideCallArguments o) {
    visitCompositeElement(o);
  }

  public void visitCallExpr(@NotNull RideCallExpr o) {
    visitExpr(o);
  }

  public void visitDivExpr(@NotNull RideDivExpr o) {
    visitExpr(o);
  }

  public void visitEqualExpr(@NotNull RideEqualExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull RideExpr o) {
    visitCompositeElement(o);
  }

  public void visitLessExpr(@NotNull RideLessExpr o) {
    visitExpr(o);
  }

  public void visitMinusExpr(@NotNull RideMinusExpr o) {
    visitExpr(o);
  }

  public void visitMoreExpr(@NotNull RideMoreExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull RideMulExpr o) {
    visitExpr(o);
  }

  public void visitNotEqualExpr(@NotNull RideNotEqualExpr o) {
    visitExpr(o);
  }

  public void visitParenExpr(@NotNull RideParenExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull RidePlusExpr o) {
    visitExpr(o);
  }

  public void visitSimpleRefExpr(@NotNull RideSimpleRefExpr o) {
    visitExpr(o);
  }

  public void visitStatement(@NotNull RideStatement o) {
    visitCompositeElement(o);
  }

  public void visitUnaryMinExpr(@NotNull RideUnaryMinExpr o) {
    visitExpr(o);
  }

  public void visitUnaryNotExpr(@NotNull RideUnaryNotExpr o) {
    visitExpr(o);
  }

  public void visitVarDeclarationStatement(@NotNull RideVarDeclarationStatement o) {
    visitCompositeElement(o);
  }

  public void visitVarDefinition(@NotNull RideVarDefinition o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull RideNamedElement o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@NotNull RideCompositeElement o) {
    visitElement(o);
  }

}
