package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class MarkdownReportFactory extends ReportFactory {

    public static String getMarkdownReport(ParkingManager parkingManager) {
        String reportSelf = getSelfReportData("# ", parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> getSelfReportData("## ", parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "#" + getMarkdownReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    private static String getMarkdownReport(ParkingAgent parkingAgent) {
        String reportSelf = getSelfReportData("# ", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> getSelfReportData("### ", parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
