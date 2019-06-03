package com.ocp;

public interface Pool<T> {

  /**
   * @return object from object pool
   */
  T get();

  /**
   * release object back in object pool
   */

  void release(T obj);

  /**
   * initialize a pool
   */

  void initialize();

  /**
   * shutdownCalled the pool
   */
  void shutdown();

}
