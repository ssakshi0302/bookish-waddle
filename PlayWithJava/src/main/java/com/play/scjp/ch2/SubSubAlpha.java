package com.play.scjp.ch2;

public class SubSubAlpha extends Alpha {
  private SubSubAlpha() {s += "3";}

  public static void main(String[] args) {
    Thread thread = new Thread();

    new SubSubAlpha();
    System.out.println(s);

  }

}

class Alpha {
  static String s = "";

  protected Alpha() {s += "alpha";}

}

class SubAlpha extends Alpha {
  private SubAlpha() {s += "sub";}
}