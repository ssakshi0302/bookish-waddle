package com.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
  final int MAX_SIZE = 5;
  Queue<T> queue = new LinkedList<>();
  int head;
  int tail;
  private Object lock = new Object();

  public static void main(String[] args) {
    BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
/*
    Thread producer = new Thread(new Producer(blockingQueue));
    Thread consumer = new Thread(new Consumer(blockingQueue));
    producer.start();
    consumer.start();
*/


    //  ExecutorService executorService = Executors.newFixedThreadPool(20);
    // for (int i = 0; i < 20; i++) {
    //  executorService.submit(new Producer(blockingQueue));
    //}
    //for (int i = 0; i < 20; i++) {
    // executorService.submit(new Consumer(blockingQueue));
    //}
    // executorService.shutdown();
  }

  void enqueue(T element) throws InterruptedException {

    synchronized (lock) {
      while (queue.size() == MAX_SIZE) {
        lock. wait();

      }
      lock.notifyAll();
    }
    System.out.println(Thread.currentThread().getName() + " enqueue "+ element);
    // notifyAll();
    queue.add(element);
    tail++;
  }

  T dequeue() throws InterruptedException {
   synchronized (lock) {
    while (queue.isEmpty()) {
      lock.wait();
    }
    lock.notifyAll();
    System.out.println(Thread.currentThread().getName() + "deququ");
   }
    //notifyAll();
    head++;
    return queue.poll();
  }
}

class Producer implements Runnable {

  private final BlockingQueue<Integer> queue;

  Producer(final BlockingQueue<Integer> queue) {this.queue = queue;}

  @Override
  public void run() {
    try {
      for (int i = 0; i < 500; i++) {
        queue.enqueue(i);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Consumer implements Runnable {

  private final BlockingQueue<Integer> queue;

  Consumer(final BlockingQueue<Integer> queue) {this.queue = queue;}

  @Override
  public void run() {
    try {
      for (int i = 0; i < 500; i++) {
        System.out.println(Thread.currentThread().getName() + queue.dequeue());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
