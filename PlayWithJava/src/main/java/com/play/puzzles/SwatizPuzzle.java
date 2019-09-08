package com.play.puzzles;

public class SwatizPuzzle {

  public static void main(String[] args) {
    SwatizPuzzle puzzle = new SwatizPuzzle();
    SwatizPuzzle.Seekho seekho = (int a) -> {System.out.println(a);};
  }

  interface Seekho {
    void help(int a);
  }
}
