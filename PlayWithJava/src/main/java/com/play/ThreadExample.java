package com.play;

public class ThreadExample {

  public static void main(String[] args) throws InterruptedException {
    System.out.println(Thread.currentThread().getName());
    Runnable r = () -> {
      try {
        Thread.sleep(5000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };
    Thread t = new Thread(r);
    t.start();
    for (int i = 0; i < 10; i++) {
      new Thread("" + i) {
        public void run() {
          System.out.println("Thread: " + getName() + " running");
        }
      }.start();
    }
    t.join();
    System.out.println("Helfnvr v");
  }
}