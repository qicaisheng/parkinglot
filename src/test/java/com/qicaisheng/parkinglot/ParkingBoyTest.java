package com.qicaisheng.parkinglot;

import com.qicaishemg.parkinglot.Car;
import com.qicaishemg.parkinglot.ParkingLot;
import com.qicaishemg.parkinglot.ParkingLotFullException;
import com.qicaishemg.parkinglot.ParkingLotWithoutTheCar;
import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {
    
    @Test
    public void should_be_picked_up_from_managed_parking_lot_when_park_boy_park_card() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        
        parkingBoy.park(car);
        
        Car pickedCar = parkingLot.pick(car);
        Assert.assertEquals(car, pickedCar);
    }

    @Test
    public void should_be_picked_up_from_parking_boy_when_park_boy_park_card() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        parkingBoy.park(car);

        Car pickedCar = parkingBoy.pick(car);
        Assert.assertEquals(car, pickedCar);
    }

    @Test(expected = ParkingLotWithoutTheCar.class)
    public void should_not_be_picked_up_from_parking_boy_when_the_parked_car_has_been_picked_from_managed_parking_lot() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingBoy.park(car);

        parkingLot.pick(car);

        parkingBoy.pick(car);
    }

    @Test(expected = ParkingLotWithoutTheCar.class)
    public void should_not_be_picked_up_from_parking_boy_again_when_the_parked_car_has_been_picked_from_parking_boy() throws ParkingLotWithoutTheCar, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingBoy.park(car);

        parkingBoy.pick(car);

        parkingBoy.pick(car);
    }

}
