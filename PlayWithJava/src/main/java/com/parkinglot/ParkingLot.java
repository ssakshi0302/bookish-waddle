package com.parkinglot;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
  int noOfSlots;
  int noOfEntryPoints;
  List<ParkingSlot> parkingSlotList;

}
