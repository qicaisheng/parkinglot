package com.qicaisheng.parkinglot;

import com.qicaishemg.parkinglot.Car;
import com.qicaishemg.parkinglot.ParkingLot;
import com.qicaishemg.parkinglot.ParkingLotFullException;
import com.qicaishemg.parkinglot.ParkingLotWithoutTheCar;

public class ParkingBoy {
    
    private ParkingLot managedParkingLot;
    
    public ParkingBoy(ParkingLot parkingLot) {
        this.managedParkingLot = parkingLot;
    }

    public void park(Car car) throws ParkingLotFullException {
        managedParkingLot.park(car);
    }

    public Car pick(Car car) throws ParkingLotWithoutTheCar {
        return managedParkingLot.pick(car);
    }
}
