package com.chess;

public class Pawn extends ChessPiece {
  @Override
  public boolean canMove(final Square start, final Square end) {
    return false;
  }
}
