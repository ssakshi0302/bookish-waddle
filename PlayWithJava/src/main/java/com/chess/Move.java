package com.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {

  Square startPoint;
  Square endPoint;
  boolean pieceKilled;
  boolean isCastlingMove;
  boolean checkMate;
  Player player;
}
