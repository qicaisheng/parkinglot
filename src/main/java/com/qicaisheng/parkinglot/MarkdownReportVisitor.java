package com.qicaisheng.parkinglot;

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
    public String visitSelf(ParkingAgent parkingAgent) {
        return visit("## ", parkingAgent);
    }

    @Override
    public String visitSelfInParkingAgent(ParkingLot parkingLot) {
        return visit("### ", parkingLot);
    }

}
