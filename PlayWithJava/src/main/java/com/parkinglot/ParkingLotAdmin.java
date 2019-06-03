package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParkingLotAdmin {

  private ParkingLot parkingLot;
  private ParkingService parkingService;
  private ParkingLotQueryService queryService;

  public static void main(String[] args) {
    ParkingLotAdmin admin = new ParkingLotAdmin();
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      System.out.println("Enter the function you want to perform");
      int function = scanner.nextInt();
      switch (function) {
        case 0:
          admin.createParkingLot(scanner.nextInt(), scanner.nextInt());
          break;
        case 1:
          admin.getParkingService().park(scanner.next(), scanner.next(), scanner.nextInt());
          break;
        case 2:
          admin.getParkingService().depark(scanner.nextInt());
          break;
        case 3:
          admin.getParkingService().readRecords();
          break;

      }
      System.out.println("Do you want to contnue");
      flag = scanner.next().equalsIgnoreCase("y") ? true : false;
    }
    scanner.close();

  }

  void createParkingLot(int slots, int entryPoints) {
    if (parkingLot == null) {
      createParkingLot(slots);
      final Map<Integer, Integer> entryPointNearestSlotMap = populateNearestEntryPointMap(slots, entryPoints);
      parkingService = new ParkingService(parkingLot, entryPointNearestSlotMap, new ParkingLotDao());
      System.out.println("Parking lot created");
    } else {
      System.out.println("Parking lot already created");
    }
  }

  private Map<Integer, Integer> populateNearestEntryPointMap(final int slots, final int entryPoints) {
    Map<Integer, Integer> entryPointNearestSlotMap = new HashMap<>();
    int noOfSlotPerEntry = slots / entryPoints;
    int index = 0;
    int slotNo = 0;
    while (index < entryPoints) {
      entryPointNearestSlotMap.put(index, slotNo);
      index++;
      slotNo += noOfSlotPerEntry;
    }
    return entryPointNearestSlotMap;
  }

  private void createParkingLot(final int slots) {
    parkingLot = new ParkingLot();
    List<ParkingSlot> parkingSlotList = new ArrayList<>();
    for (int i = 0; i < slots; i++) {
      ParkingSlot parkingSlot = new ParkingSlot();
      parkingSlotList.add(parkingSlot);
    }

    parkingLot.setParkingSlotList(parkingSlotList);
  }

  public ParkingLot getParkingLot() {return this.parkingLot;}

  public ParkingService getParkingService() {return this.parkingService;}

  public ParkingLotQueryService getQueryService() {return this.queryService;}
}
