package com.qicaisheng.parkinglot;

import java.util.List;

public class ParkingManager extends ParkingAgent {
    
    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    ParkingLot selectParkingLot() {
        return managedParkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().orElse(null);
    }
}
