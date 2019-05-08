package com.qicaisheng.parkinglot;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ParkingAgent {
    
    protected List<ParkingLot> managedParkingLots;
    
    public ParkingAgent(List<ParkingLot> parkingLots) {
        this.managedParkingLots = parkingLots;
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
    
    protected int availableParkingSpaces() {
        return managedParkingLots.stream().mapToInt(ParkingLot::availableSpaces).sum();
    }

    protected int parkingCapacity() {
        return managedParkingLots.stream().mapToInt(ParkingLot::getCapacity).sum();
    }
    
    private ParkingLot selectParkingLotWithTheCar(Car car) {
        return managedParkingLots.stream().filter(parkingLot -> parkingLot.haveTheCar(car)).findFirst().orElse(null);
    }

    abstract ParkingLot selectParkingLot();

    public String report() {
        String reportSelf = "B " + availableParkingSpaces() + " " + parkingCapacity() + "\n";
        String reportMangedParkingLots = managedParkingLots.stream().map(parkingLot -> "\t\tP " + parkingLot.availableSpaces() + " " + parkingLot.getCapacity() + "\n").collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    };
}
