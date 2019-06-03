package com.gfg;

import java.util.TreeSet;

public class Treeset {
  public static void main(String[] args) {
    TreeSet<String> treeset = new TreeSet<>();
    treeset.add("Neeks");
    treeset.add("keeks");
    treeset.add("Afor");
    treeset.add("for");
    treeset.add("Deeks");
    treeset.add("leeks");
    treeset.add("GeeksForGeeks");
    for (String temp : treeset)
      System.out.printf(temp + " ");

    System.out.println("\n");
  }
}
