package com.qicaisheng.parkinglot;

import com.qicaishemg.parkinglot.Car;
import com.qicaishemg.parkinglot.ParkingLot;
import com.qicaishemg.parkinglot.ParkingLotFullException;
import com.qicaishemg.parkinglot.ParkingLotWithoutTheCar;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class ParkingBoyTest {
    
    @Test
    public void should_be_picked_up_from_managed_parking_lot_when_park_boy_park_card() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();
        
        parkingBoy.park(car);
        
        Car pickedCar = parkingLot.pick(car);
        Assert.assertEquals(car, pickedCar);
    }

    @Test
    public void should_be_picked_up_from_parking_boy_when_park_boy_park_card() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();

        parkingBoy.park(car);

        Car pickedCar = parkingBoy.pick(car);
        Assert.assertEquals(car, pickedCar);
    }

    @Test(expected = ParkingLotWithoutTheCar.class)
    public void should_not_be_picked_up_from_parking_boy_when_the_parked_car_has_been_picked_from_managed_parking_lot() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();
        parkingBoy.park(car);

        parkingLot.pick(car);

        parkingBoy.pick(car);
    }

    @Test(expected = ParkingLotWithoutTheCar.class)
    public void should_not_be_picked_up_from_parking_boy_again_when_the_parked_car_has_been_picked_from_parking_boy() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();
        parkingBoy.park(car);

        parkingBoy.pick(car);

        parkingBoy.pick(car);
    }

    @Test(expected = ParkingLotFullException.class)
    public void should_not_be_parked_from_parking_boy_when_the_managed_parking_lot_is_full() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();
        parkingBoy.park(car);

        Car cannotBeParkedCar = new Car();
        parkingBoy.park(cannotBeParkedCar);
    }

    @Test
    @Ignore
    public void should_be_picked_from_two_parking_lots_when_parking_boy_park_two_cars_in_order() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        parkingBoy.park(car);

        Car cannotBeParkedCar = new Car();
        parkingBoy.park(cannotBeParkedCar);
    }
}
