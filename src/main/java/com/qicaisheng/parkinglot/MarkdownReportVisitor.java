package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class MarkdownReportVisitor extends ReportVisitor {
    
    @Override
    public String visitSelfInParkingManager(ParkingLot parkingLot) {
        return visit("## ", parkingLot);
    }

    @Override
    public String visitSelf(ParkingManager parkingManager) {
        return visit("# ", parkingManager);
    }

    @Override
    public String visit(ParkingAgent parkingAgent) {
        String reportSelf = visitSelf(parkingAgent);
        String reportMangedParkingLots = parkingAgent.getManagedParkingLots().stream().map(parkingLot -> visitSelfInParkingAgent(parkingLot)).collect(Collectors.joining());
        return reportSelf + reportMangedParkingLots;
    }

    @Override
    public String visitSelf(ParkingAgent parkingAgent) {
        return visit("## ", parkingAgent);
    }

    @Override
    public String visitSelfInParkingAgent(ParkingLot parkingLot) {
        return visit("### ", parkingLot);
    }

}
