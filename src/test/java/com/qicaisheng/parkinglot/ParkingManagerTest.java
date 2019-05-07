package com.qicaisheng.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingManagerTest {

    @Test
    public void should_be_able_to_pick_the_parked_car_when_parking_manager_park_the_car() throws ParkingLotFullException, ParkingLotWithoutTheCar {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        
        parkingManager.park(car);

        Assert.assertEquals(car, parkingManager.pick(car));
    }
}
