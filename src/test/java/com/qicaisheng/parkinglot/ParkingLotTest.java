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

    @Test
    public void should_not_be_able_to_pick_up_again_when_the_card_pick_up_from_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);

        parkingLot.pick(car);
        
        boolean canBePick = parkingLot.pick(car);
        Assert.assertFalse(canBePick);
    }

}
