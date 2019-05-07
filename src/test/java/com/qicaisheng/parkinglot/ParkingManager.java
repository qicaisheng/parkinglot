package com.qicaisheng.parkinglot;

import java.util.List;

public class ParkingManager {
    
    private List<ParkingAgent> managedParkingBoys;
    
    private List<ParkingLot> managedParkingLots;
    
    public ParkingManager(List<ParkingLot> parkingLots) {
        managedParkingLots = parkingLots;
    }

    public void manager(List<ParkingAgent> parkingBoys) {
        managedParkingBoys = parkingBoys;
    }

    public void park(Car car, ParkingLot parkingLot) throws ParkingLotFullException, WithoutManagedTheParkingBoyException {
        if (!managedParkingLots.contains(parkingLot)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        parkingLot.park(car);
    }

    public Car pick(Car car, ParkingLot parkingLot) throws ParkingLotWithoutTheCar, WithoutManagedTheParkingBoyException {
        if (!managedParkingLots.contains(parkingLot)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        return parkingLot.pick(car);
    }


    public void park(Car car, ParkingAgent parkingBoy) throws ParkingLotFullException, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        parkingBoy.park(car);
    }

    public Car pick(Car car, ParkingAgent parkingBoy) throws ParkingLotWithoutTheCar, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        return parkingBoy.pick(car);
    }
}
