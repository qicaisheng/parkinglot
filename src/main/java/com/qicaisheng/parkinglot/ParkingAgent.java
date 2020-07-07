package com.qicaisheng.parkinglot;

import java.util.List;

public abstract class ParkingAgent implements ParkingResource {

    public List<ParkingLot> getManagedParkingLots() {
        return managedParkingLots;
    }

    protected List<ParkingLot> managedParkingLots;
    
    public ParkingAgent(List<ParkingLot> parkingLots) {
        this.managedParkingLots = parkingLots;
    }

    @Override
    public String getShortName() {
        return "B";
    }

    @Override
    public int getAvailableSpaces() {
        return managedParkingLots.stream().mapToInt(ParkingLot::getAvailableSpaces).sum();
    }

    @Override
    public int getCapacity() {
        return managedParkingLots.stream().mapToInt(ParkingLot::getCapacity).sum();
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

    private ParkingLot selectParkingLotWithTheCar(Car car) {
        return managedParkingLots.stream().filter(parkingLot -> parkingLot.haveTheCar(car)).findFirst().orElse(null);
    }

    abstract ParkingLot selectParkingLot();
}
