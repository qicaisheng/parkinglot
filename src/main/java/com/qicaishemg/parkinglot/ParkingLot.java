package com.qicaishemg.parkinglot;

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

    public Car pick(Car car) throws ParkingLotWithoutTheCar {
        if (!parkedCar.contains(car)) {
            throw new ParkingLotWithoutTheCar();
        }
        parkedCar.remove(car);
        return car;
    }
    
    public boolean haveTheCar(Car car) {
        return parkedCar.contains(car);
    }

    public boolean isFull() {
        return parkedCar.size() >= capacity;
    }
}
