package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class MarkdownReportVisitor extends ReportVisitor {

    @Override
    public String visit(ParkingManager parkingManager) {
        String reportSelf = visitSelf(parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingManager(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(this::visit).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    private String visitSelfInParkingManager(ParkingLot parkingLot) {
        return visit("## ", parkingLot);
    }

    private String visitSelf(ParkingManager parkingManager) {
        return visit("# ", parkingManager);
    }

    @Override
    public String visit(ParkingAgent parkingAgent) {
        String reportSelf = visit("## ", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingAgent(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    private String visitSelfInParkingAgent(ParkingLot parkingLot) {
        return visit("### ", parkingLot);
    }

}
