package com.ocp;

import java.sql.Connection;

public class Main {

  public static void main(String[] args) {
    final Pool<Connection> blockingPool = PoolFactory.createBlockingPool(50);
  }

}
