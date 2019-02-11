package com.play.thread;

public class OddEvenThread {

  static int count = 0;
  static int MAX = 50;
  static Object lock = new Object();

  public static void main(String[] args) {
    Thread odd = new Thread(() -> printOdd(),"odd");
    Thread even = new Thread(() -> printEven(), "even");
    Thread test = new Thread(()-> {for(int i=0; i<50;i++){System.out.println("hello");}},"hello");
    even.start();
    test.start();
    odd.start();

  }

  static void printOdd() {
 //   System.out.println(Thread.currentThread().getName() + " is running");
    while (count < MAX) {
      if (count % 2 != 0) {
        System.out.println("odd printing   " + count);
        count++;
      }
    }
  }

  static void printEven() {
   // System.out.println(Thread.currentThread().getName() + " is running");
    while (count < MAX) {
     synchronized (lock) {
        if (count % 2 == 0) {
          System.out.println("even printing   " + count);
          count++;
        }
     }
    }
  }

}

