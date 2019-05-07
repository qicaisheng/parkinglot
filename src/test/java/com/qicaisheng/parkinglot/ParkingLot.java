package com.qicaisheng.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    
    private int capacity;
    
    private List<Car> parkedCar = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void park(Car car) throws ParkingLotFullException {
        if (isFull()) {
            throw new ParkingLotFullException();
        }
        parkedCar.add(car);
    }

    public boolean pick(Car car) throws ParkingLotWithoutTheCar {
        if (!parkedCar.contains(car)) {
            throw new ParkingLotWithoutTheCar();
        }
        return parkedCar.remove(car);
    }

    public boolean isFull() {
        return parkedCar.size() >= capacity;
    }
}
