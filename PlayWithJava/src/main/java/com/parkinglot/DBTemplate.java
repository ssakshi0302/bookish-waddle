package com.parkinglot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBTemplate {
  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:~/test";

  //  Database credentials
  static final String USER = "sa";
  static final String PASS = "";

  private static Connection conn;

  static {
    Statement stmt = null;
    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
//      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 3: Execute a query
      //    System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      String sql2 = "DROP TABLE if exists parking_slot";
      stmt.executeUpdate(sql2);
      System.out.println("table dropped");
      String sql = "CREATE TABLE if not exists  parking_slot " +
          "(id INTEGER not NULL auto_Increment, " +
          " slotNo Integer not null, " +
          " registerationNo VARCHAR(255), " +
          " color VARCHAR(255), " +
          " PRIMARY KEY ( id ))";
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");

      // STEP 4: Clean-up environment
      stmt.close();
      //   conn.close();
    } catch (SQLException se) {
      //Handle errors for JDBC
      se.printStackTrace();
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null) stmt.close();
      } catch (SQLException se2) {
      } // nothing we can do
      try {
        if (conn != null) conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      } //end finally try
    } //end try

  }

  public void insertRecord(String regNo, String color, int slotNo) {

    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "INSERT INTO parking_slot(registerationNo, color, slotNo) " + "VALUES ('" + regNo + "', '"
          + color + "'," + slotNo + ")";
      stmt.executeUpdate(sql);

    } catch (SQLException e) {
      System.out.println("error in insert " + e);
    }

  }

  public void readRecord() {
    Statement stmt = null;
//    Class.forName(JDBC_DRIVER);

    //STEP 2: Open a connection
    System.out.println("Connecting to database...");

    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "select * from parking_slot";
      ResultSet rs = stmt.executeQuery(sql);

      // STEP 4: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        int slotNo = rs.getInt("slotNo");
        String color = rs.getString("color");
        String regNo = rs.getString("registerationNo");
        System.out.println(regNo + " , " + color + " , " + slotNo);

      }
      // STEP 5: Clean-up environment
      rs.close();

    } catch (SQLException e) {
      System.out.println("error in read, " + e);
    }

  }

  public void remove(final int slotNo) {
    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      String sql = "DELETE FROM parking_slot " + "WHERE slotNo =" + slotNo;
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // STEP 3: Execute a query

  }
}

