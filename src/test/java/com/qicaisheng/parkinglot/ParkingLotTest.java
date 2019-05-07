package com.qicaisheng.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    
    @Test
    public void should_be_able_to_pick_up_when_the_card_park_into_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        
        parkingLot.park(car);
        
        boolean canBePick = parkingLot.pick(car);
        Assert.assertTrue(canBePick);
    }

    @Test
    public void should_not_be_able_to_pick_up_again_when_the_card_pick_up_from_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);

        parkingLot.pick(car);
        
        boolean canBePick = parkingLot.pick(car);
        Assert.assertFalse(canBePick);
    }

    @Test
    public void should_be_full_when_the_parked_car_size_meet_parking_lot_max_capacity() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        
        parkingLot.park(car);

        Assert.assertTrue(parkingLot.isFull());
    }

    @Test
    public void should_not_be_full_when_the_parked_car_size_not_meet_parking_lot_max_capacity() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.park(car);

        Assert.assertFalse(parkingLot.isFull());
    }

}
