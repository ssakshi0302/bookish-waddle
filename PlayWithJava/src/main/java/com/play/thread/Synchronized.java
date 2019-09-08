package com.play.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronized {

  static String classVar;
  static Integer counter;

  public synchronized   void  checkCounter () {
    counter++;
    System.out.println(Thread.currentThread().getName()+ counter);
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.submit(()->new Synchronized().checkCounter());

    Synchronized sync1 = new Synchronized();
    Synchronized sync2 = new Synchronized();
    Synchronized sync3 = new Synchronized();
    Synchronized sync4 = new Synchronized();
    sync1.checkCounter();
    sync2.checkCounter();
  }


}
