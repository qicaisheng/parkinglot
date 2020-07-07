package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportVisitor extends ReportVisitor {

    @Override
    public String visit(ParkingManager parkingManager) {
        String reportSelf = visit("", parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> visit("\t", parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(this::visit).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    @Override
    public String visit(ParkingAgent parkingAgent) {
        String reportSelf = visit("\t", parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> visit("\t\t", parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

}
