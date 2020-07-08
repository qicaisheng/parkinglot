package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportVisitor extends ReportVisitor {

    @Override
    public String visit(ParkingManager parkingManager) {
        String reportSelf = visitSelf(parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingManager(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(this::visit).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    @Override
    public String visitSelfInParkingManager(ParkingLot parkingLot) {
        return visit("\t", parkingLot);
    }

    @Override
    public String visitSelf(ParkingManager parkingManager) {
        return visit("", parkingManager);
    }

    @Override
    public String visit(ParkingAgent parkingAgent) {
        String reportSelf = visit("\t", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingAgent(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    @Override
    public String visitSelfInParkingAgent(ParkingLot parkingLot) {
        return visit("\t\t", parkingLot);
    }

}
