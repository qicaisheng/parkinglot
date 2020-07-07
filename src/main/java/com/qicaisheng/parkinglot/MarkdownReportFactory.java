package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class MarkdownReportFactory extends ReportFactory {

    @Override
    public String report(ParkingManager parkingManager) {
        String reportSelf = report("# ", parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> report("## ", parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(parkingAgent -> "#" + report(parkingAgent)).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    @Override
    public String report(ParkingAgent parkingAgent) {
        String reportSelf = report("# ", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> report("### ", parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
