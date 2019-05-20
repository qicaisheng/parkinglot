package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class ReportFactory {

    public static String getTextReport(ParkingManager parkingManager) {
        String reportSelf = parkingManager.getSelfReportData("");
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> "\t" + parkingLot.getSelfReportData("")).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "\t" + getTextReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }


    public static String getMarkdownReport(ParkingManager parkingManager) {
        String reportSelf = parkingManager.getSelfReportData("# ");
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> "#" + parkingLot.getSelfReportData("# ")).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "#" + getMarkdownReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    private static String getTextReport(ParkingAgent parkingAgent) {
        String reportSelf = parkingAgent.getSelfReportData("");
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> "\t\t" + parkingLot.getSelfReportData("")).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    private static String getMarkdownReport(ParkingAgent parkingAgent) {
        String reportSelf = parkingAgent.getSelfReportData("# ");
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> "### " + parkingLot.getSelfReportData("")).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
