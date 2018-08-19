package com.play.puzzles;

import java.util.HashMap;
import java.util.Map;

public class Test {
  static boolean initialized = false;

  static {
    Thread thread = new Thread(() -> {
      // initialized = true;
      System.out.println("initialized value in static thread : " + initialized + ", thread id : " + Thread.currentThread().getName());
    });
    thread.start();
    // try {
    System.out.println("before join" + ", thread id : " + Thread.currentThread().getName());
    // Thread.sleep(7000);
    System.out.println("after sleep" + ", thread id : " + Thread.currentThread().getName());
    // thread.join();
    System.out.println("hihi" + ", thread id : " + Thread.currentThread().getName());
        /*} catch (InterruptedException e) {
        throw new AssertionError(e);
        }*/
  }

  public static void main(String[] args) {
    Map<String, String> test = new HashMap<>();
    test.put("1", "10");
    String s = test.get("1");
    test.put("1", "20");
    System.out.println(s);
  }

}