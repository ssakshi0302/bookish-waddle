package com.ocp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingPool<T> implements Pool<T> {

  final int size;
  final ObjectFactory<T> factory;
  BlockingQueue<T> queue;
  boolean shutdownCalled;

  public BlockingPool(final int size, final ObjectFactory<T> factory) {
    this.size = size;
    this.factory = factory;
  }

  @Override
  public T get() {
    if (!shutdownCalled) {
      try {
        return queue.take();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      return null;
    }
    throw new IllegalStateException("pool already shutdownCalled");
  }

  @Override
  public void release(final T obj) {
    if (!shutdownCalled) {
      try {
        queue.put(obj);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  @Override
  public void initialize() {
    queue = new LinkedBlockingQueue<>();
    for (int i = 0; i < size; i++) {
      queue.add(factory.createObject());
    }
    shutdownCalled = false;
  }

  @Override
  public void shutdown() {
    shutdownCalled = true;
    clearPool();
  }

  private void clearPool() {
    while (!queue.isEmpty()) {
      queue.remove();
    }
  }
}
