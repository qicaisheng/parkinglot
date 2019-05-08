package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class ReportFactory {

    public static String report(ParkingAgent parkingAgent) {
        String reportSelf = "B " + parkingAgent.availableParkingSpaces() + " " + parkingAgent.parkingCapacity() + "\n";
        String reportMangedParkingLots = parkingAgent.managedParkingLots.stream().map(parkingLot -> "\t\tP " + parkingLot.availableSpaces() + " " + parkingLot.getCapacity() + "\n").collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    public static String report(ParkingLot parkingLot) {
        return "P " + parkingLot.availableSpaces() + " " + parkingLot.getCapacity() + "\n";
    }

    public static String report(ParkingManager parkingManager) {
        String reportSelf = "M " + parkingManager.availableParkingSpaces() + " " + parkingManager.parkingCapacity() + "\n";
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> "\t" + report(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "\t" + report(parkingAgent)).collect(Collectors.joining());
        
        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
}
