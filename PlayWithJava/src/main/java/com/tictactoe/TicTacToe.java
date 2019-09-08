package com.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class TicTacToe {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("4");
    set.add("5");
    set.remove(set.size()-1);
  }
}
