package com.qicaisheng.parkinglot;

import java.util.List;

public class ParkingBoy {
    
    protected List<ParkingLot> managedParkingLots;
    
    private int parkingLotIndex;
    
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.managedParkingLots = parkingLots;
        this.parkingLotIndex = 0;
    }

    public void park(Car car) throws ParkingLotFullException {
        selectParkingLot().park(car);
    }

    public Car pick(Car car) throws ParkingLotWithoutTheCar {
        ParkingLot parkingLot = selectParkingLotWithTheCar(car);
        if (parkingLot == null) {
            throw new ParkingLotWithoutTheCar();
        }
        return parkingLot.pick(car);
    }
    
    public ParkingLot selectParkingLot() {
        ParkingLot parkingLot = managedParkingLots.get(parkingLotIndex);
        parkingLotIndex = (parkingLotIndex + 1) % managedParkingLots.size();
        return parkingLot;
    }
    
    private ParkingLot selectParkingLotWithTheCar(Car car) {
        return managedParkingLots.stream().filter(parkingLot -> parkingLot.haveTheCar(car)).findFirst().orElse(null);
    }
}
