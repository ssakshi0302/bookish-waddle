package com.chess;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {
  GameBoard gameBoard;
  GameStatus status;
  int turn;
  List<Move> moves;

  GameBoard initialize(){
    gameBoard = new GameBoard();
    return gameBoard;
  }

}
