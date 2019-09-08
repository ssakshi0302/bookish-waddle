package com.chess;

public abstract class ChessPiece {

  boolean white;
  boolean killed;

  public abstract boolean canMove(Square start, Square end);
}
