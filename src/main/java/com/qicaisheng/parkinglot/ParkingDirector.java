package com.qicaisheng.parkinglot;

public class ParkingDirector {
    
    private ParkingManager managedParkingManager;
    
    public void manage(ParkingManager parkingManager) {
        managedParkingManager = parkingManager;
    }

    public String report() {
        return managedParkingManager.report();
    }
}
