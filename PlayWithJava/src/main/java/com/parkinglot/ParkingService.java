package com.parkinglot;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingService {

  private static Set<Integer> vacantSlots = new HashSet<>();
  private final Map<Integer, Integer> nearestEntryPointSlotMap;
  private final ParkingLot parkingLot;
  private final ParkingLotDao parkingLotDao;

  public ParkingService(final ParkingLot parkingLot, final Map<Integer, Integer> entryPointNearestSlotMap, final ParkingLotDao parkingLotDao) {
    this.parkingLot = parkingLot;
    this.nearestEntryPointSlotMap = entryPointNearestSlotMap;
    this.parkingLotDao = parkingLotDao;
    for (int i = 0; i < parkingLot.getParkingSlotList().size(); i++) {
      vacantSlots.add(i);
    }
  }

  void park(final String registerationNo, final String color, final int entryPoint) {
    if (vacantSlots.size() == 0) {
      System.out.println("No slot available");
    } else {
      final int nearestVacantSlot = findNearestVacantSlot(entryPoint);
      parkCarToSlot(nearestVacantSlot, registerationNo, color);
      removeSlotFromVacantList(nearestVacantSlot);
      System.out.println("Allocated slot no " + nearestVacantSlot);
    }

  }

  private int findNearestVacantSlot(final int entryPoint) {
    int nearestSlot = nearestEntryPointSlotMap.get(entryPoint);
    for (int slotNo = nearestSlot; slotNo < parkingLot.getParkingSlotList().size(); slotNo++) {
      if (vacantSlots.contains(slotNo)) {
        return slotNo;
      }
    }
    //no slot afternearest point
    for (int slotNo = 0; slotNo < nearestSlot; slotNo++) {
      if (vacantSlots.contains(slotNo)) {
        return slotNo;
      }
    }
    return -1;
  }

  private void parkCarToSlot(final int nearestVacantSlot, final String registerationNo, final String color) {
    ParkingSlot parkingSlot = parkingLot.getParkingSlotList().get(nearestVacantSlot);
    parkingSlot.setColor(color);
    parkingSlot.setRegisterationNo(registerationNo);
    //add entryin database
    parkingLotDao.insertRecord(registerationNo, color, nearestVacantSlot);
  }

  private void removeSlotFromVacantList(final int nearestVacantSlot) {
    vacantSlots.remove(nearestVacantSlot);
  }

  void depark(final int slotNo) {
    addSlotInVacantList(slotNo);
    //removefromdb
    parkingLotDao.remove(slotNo);
    parkingLot.getParkingSlotList().set(slotNo, new ParkingSlot());
    System.out.println("slot no " + slotNo + " is free");
  }

  private void addSlotInVacantList(final int slotNo) {
    vacantSlots.add(slotNo);
  }

  public void readRecords() {
    parkingLotDao.read();
  }
}



