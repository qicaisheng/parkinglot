package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class ReportFactory {

    public static String report(ParkingAgent parkingAgent) {
        String reportSelf = "B " + parkingAgent.availableParkingSpaces() + " " + parkingAgent.parkingCapacity() + "\n";
        String reportMangedParkingLots = parkingAgent.managedParkingLots.stream().map(parkingLot -> "\t\tP " + parkingLot.availableSpaces() + " " + parkingLot.getCapacity() + "\n").collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
