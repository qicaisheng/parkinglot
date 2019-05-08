package com.qicaisheng.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingDirectorTest {

    @Test
    public void should_report_manager_managed_parking_lots() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.park(new Car());
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot1, parkingLot2));
        ParkingDirector parkingDirector = new ParkingDirector();
        parkingDirector.manage(parkingManager);
        
        String report = parkingDirector.report();
        
        Assert.assertEquals("M 2 3\n\tP 1 1\n\tP 1 2\n", report);
    }
}
