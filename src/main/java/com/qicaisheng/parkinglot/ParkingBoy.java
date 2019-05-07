package com.qicaisheng.parkinglot;

import com.qicaishemg.parkinglot.Car;
import com.qicaishemg.parkinglot.ParkingLot;
import com.qicaishemg.parkinglot.ParkingLotFullException;
import com.qicaishemg.parkinglot.ParkingLotWithoutTheCar;

import java.util.List;

public class ParkingBoy {
    
    private List<ParkingLot> managedParkingLots;
    
    private ParkingLot lastParkingLot;
    
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.managedParkingLots = parkingLots;
    }

    public void park(Car car) throws ParkingLotFullException {
        selectParkingLot().park(car);
    }

    public Car pick(Car car) throws ParkingLotWithoutTheCar {
        return managedParkingLots.get(0).pick(car);
    }
    
    private ParkingLot selectParkingLot() {
        return managedParkingLots.get(0);
    }
}
