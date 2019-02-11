package com.parkinglot;

public class ParkingLotDao {
  private static DBTemplate dbTemplate = new DBTemplate();

  void remove(int slotNo) {
    dbTemplate.remove(slotNo);
  }

  void insertRecord(String regNo, String color, int slotNo) {
    dbTemplate.insertRecord(regNo, color, slotNo);
  }

  public void read() {
    dbTemplate.readRecord();
  }
}
