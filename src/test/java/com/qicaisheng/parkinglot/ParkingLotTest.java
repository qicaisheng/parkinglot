package com.qicaisheng.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    
    @Test
    public void should_be_able_to_pick_up_when_the_card_park_into_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        
        parkingLot.park(car);
        
        boolean canBePick = parkingLot.pick(car);
        Assert.assertTrue(canBePick);
    }
}
