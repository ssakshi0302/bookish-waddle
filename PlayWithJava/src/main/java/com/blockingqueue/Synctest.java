package com.blockingqueue;

public class Synctest {

  static Object monitor = new Synctest();

  public static void main(String[] args) throws InterruptedException {
    System.out.println("start");

    final Synctest synctest = new Synctest();
    synctest.testMonitor();

    // synctest.wait();
    System.out.println("end");
  }

  public void testMonitor() throws InterruptedException {

    synchronized (this) {
      wait();
    }
    System.out.println("ygf");
  }
}
