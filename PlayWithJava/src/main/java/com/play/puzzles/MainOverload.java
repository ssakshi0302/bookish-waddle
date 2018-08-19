package com.play.puzzles;

public class MainOverload {
  static {
    System.out.println(":P :P :P");
  }

  {
    System.out.println("hihihihi");
  }

  public MainOverload() {
    main("HIIII");
  }

  public static void main(String[] args) {
    System.out.println("Morning!!");
    new MainOverload();
  }

  public static void main(String args) {
    System.out.println("oye tu mat chal");
  }

  public static void main(Integer[] args) {

  }
}
