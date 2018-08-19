package com.play.algos.multithread;

public class MyThread extends Thread {

  StringBuffer buffer = new StringBuffer("hello");

  public MyThread(final StringBuffer buffer) {
    this.buffer = buffer;
  }

  public static void main(String[] args) {
    StringBuffer lock = new StringBuffer("Hi ");
    MyThread t1 = new MyThread(lock);
    t1.start();
    //System.out.println(t1.currentThread().getName());
    MyThread t2 = new MyThread(new StringBuffer("oww "));
    t2.start();
    //System.out.println("t2 " + t2.currentThread().getName());
    MyThread t3 = new MyThread(lock);
    t3.start();
   // System.out.println("t3 " + t3.currentThread().getName());
  }

  @Override
  public void run() {
    synchronized (buffer) {
      for (int i = 0; i < 500; i++) {
        System.out.println(buffer +  Thread.currentThread().getName());
      }


    }
  }
}