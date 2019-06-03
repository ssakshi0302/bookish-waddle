package com.ocp;

import java.sql.Connection;

public class PoolFactory {

  public static Pool<Connection> createBlockingPool(final int size) {
    final ObjectFactory<Connection> factory = new ConnectionFactory("", "", "");
    Pool<Connection> pool = new BlockingPool<>(size, factory);
    return pool;
  }
}
