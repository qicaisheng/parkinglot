package com.qicaisheng.parkinglot;

import java.util.List;

public class ParkingManager extends ParkingAgent {
    
    private List<ParkingBoy> managedParkingBoys;
    
    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    ParkingLot selectParkingLot() {
        return managedParkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().orElse(null);
    }

    public void manager(List<ParkingBoy> parkingBoys) {
        managedParkingBoys = parkingBoys;
    }

    public void park(Car car, ParkingBoy parkingBoy) throws ParkingLotFullException, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        parkingBoy.park(car);
    }

    public Car pick(Car car, ParkingBoy parkingBoy) throws ParkingLotWithoutTheCar, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        return parkingBoy.pick(car);
    }
}
