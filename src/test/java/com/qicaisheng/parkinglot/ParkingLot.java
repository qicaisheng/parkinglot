package com.qicaisheng.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    
    private List<Car> parkedCar = new ArrayList<>();
    
    public void park(Car car) {
        parkedCar.add(car);
    }

    public boolean pick(Car car) {
        return parkedCar.remove(car);
    }
}
