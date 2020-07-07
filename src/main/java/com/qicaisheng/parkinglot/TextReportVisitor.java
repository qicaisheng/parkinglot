package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportVisitor extends ReportVisitor {

    @Override
    public String report(ParkingManager parkingManager) {
        String reportSelf = report("", parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> report("\t", parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "\t" + report(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    @Override
    public String report(ParkingAgent parkingAgent) {
        String reportSelf = report("", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> report("\t\t", parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
