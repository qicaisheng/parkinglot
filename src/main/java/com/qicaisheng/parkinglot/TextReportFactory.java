package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportFactory extends ReportFactory {

    public static String getTextReport(ParkingManager parkingManager) {
        String reportSelf = getSelfReportData("", parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> getSelfReportData("\t", parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "\t" + getTextReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    private static String getTextReport(ParkingAgent parkingAgent) {
        String reportSelf = getSelfReportData("", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> getSelfReportData("\t\t", parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
