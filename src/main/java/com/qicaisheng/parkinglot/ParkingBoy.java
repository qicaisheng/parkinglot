package com.qicaisheng.parkinglot;

import com.qicaishemg.parkinglot.Car;
import com.qicaishemg.parkinglot.ParkingLot;
import com.qicaishemg.parkinglot.ParkingLotFullException;
import com.qicaishemg.parkinglot.ParkingLotWithoutTheCar;

import java.util.List;

public class ParkingBoy {
    
    private List<ParkingLot> managedParkingLots;
    
    private int parkingLotIndex;
    
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.managedParkingLots = parkingLots;
        this.parkingLotIndex = 0;
    }

    public void park(Car car) throws ParkingLotFullException {
        selectParkingLot().park(car);
    }

    public Car pick(Car car) throws ParkingLotWithoutTheCar {
        return managedParkingLots.get(0).pick(car);
    }
    
    private ParkingLot selectParkingLot() {
        ParkingLot parkingLot = managedParkingLots.get(parkingLotIndex);
        parkingLotIndex = (parkingLotIndex + 1) / (managedParkingLots.size() + 1);
        return parkingLot;
    }
}
