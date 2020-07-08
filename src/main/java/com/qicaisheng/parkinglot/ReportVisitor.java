package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public abstract class ReportVisitor {
    public String visit(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public String visit(ParkingManager parkingManager) {
        String reportSelf = visitSelf(parkingManager);
        String reportSelfManagedParkingLots = parkingManager.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingManager(parkingLot)).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = parkingManager.getManagedParkingBoys().stream().map(this::visit).collect(Collectors.joining());

        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }

    public String visit(ParkingAgent parkingAgent) {
        String reportSelf = visitSelf(parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingAgent(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    public abstract String visitSelfInParkingManager(ParkingLot parkingLot);

    public abstract String visitSelf(ParkingManager parkingManager);
    
    public abstract String visitSelf(ParkingAgent parkingAgent);

    public abstract String visitSelfInParkingAgent(ParkingLot parkingLot);
}
