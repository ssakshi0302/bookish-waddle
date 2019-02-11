package com.parkinglot;

public class ParkingLotQueryService {

  private static final ParkingLotDao parkingLotDao = new ParkingLotDao();

  public void readRecords() {
    parkingLotDao.read();
  }

}

