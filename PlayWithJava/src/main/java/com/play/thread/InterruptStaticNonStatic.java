package com.play.thread;

public class InterruptStaticNonStatic {

  public static void main(String[] args) {
    InterruptedThread t1 = new InterruptedThread();
    InterruptedThread t2 = new InterruptedThread();
    InterruptedThread t4 = new InterruptedThread();
    InterruptedThread t3 = new InterruptedThread();
    InterruptedThread t5 = new InterruptedThread();
    InterruptedThread t6 = new InterruptedThread();
    InterruptedThread t7 = new InterruptedThread();
    t1.start();
    t2.start();
    t3.start();
    t5.start();
    t6.start();
    t7.start();
    t4.start();
    // t1.interrupt();
    t1.interrupt();
    t5.interrupt();
    //  t1.interrupt();
    //t3.interrupt();

  }

  static class InterruptedThread extends Thread {

    @Override
    public void run() {
        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      for (int i = 0; i < 4000; i++) {
        if (Thread.currentThread().interrupted()) {
          System.out.println(Thread.currentThread().getName() + "m interrupted");
        } else {
          if (i % 500 == 0) {
            System.out.println(Thread.currentThread().getName() + "normal flow " + i);
          }
        }
      }
    }
  }

}
