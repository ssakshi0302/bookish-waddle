package com.ocp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements ObjectFactory<Connection> {

  private final String username;
  private final String password;
  private final String url;

  public ConnectionFactory(final String username, final String password, final String url) {
    this.username = username;
    this.password = password;
    this.url = url;
  }

  @Override
  public Connection createObject() {
    try {
      return DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      throw new IllegalArgumentException("unable to create connection");
    }
  }
}
