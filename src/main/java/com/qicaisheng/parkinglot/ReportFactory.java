package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class ReportFactory {

    public static String getTextReport(ParkingManager parkingManager) {
        String reportSelf = getSelfReportData("M ", parkingManager.availableParkingSpaces(), parkingManager.parkingCapacity(), "");
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> "\t" + getTextReport(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "\t" + getTextReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    private static String getSelfReportData(String shortName, int availableSpaces, int capacity, String prefix) {
        return prefix + shortName + availableSpaces + " " + capacity + "\n";
    }

    public static String getMarkdownReport(ParkingManager parkingManager) {
        String reportSelf = "# " + "M " + parkingManager.availableParkingSpaces() + " " + parkingManager.parkingCapacity() + "\n";
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> "#" + getMarkdownReport(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "#" + getMarkdownReport(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    private static String getTextReport(ParkingAgent parkingAgent) {
        String reportSelf = getSelfReportData("B ", parkingAgent.availableParkingSpaces(), parkingAgent.parkingCapacity(), "");
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> "\t\t" + getTextReport(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    private static String getTextReport(ParkingLot parkingLot) {
        return getSelfReportData("P ", parkingLot.availableSpaces(), parkingLot.getCapacity(), "");
    }

    private static String getMarkdownReport(ParkingAgent parkingAgent) {
        String reportSelf = getSelfReportData("B ", parkingAgent.availableParkingSpaces(), parkingAgent.parkingCapacity(), "# ");
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> "### " + getTextReport(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    private static String getMarkdownReport(ParkingLot parkingLot) {
        return getSelfReportData("P ", parkingLot.availableSpaces(), parkingLot.getCapacity(), "# ");
    }

}
