package com.play;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {
  public static void main(String[] args) {
    NavigableSet<String> set = new TreeSet<>();
    set.add("hi");
    set.add("angel");
    System.out.println(set);
  }
}
