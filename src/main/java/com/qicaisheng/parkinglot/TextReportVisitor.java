package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportVisitor extends ReportVisitor {
    
    @Override
    public String visitSelfInParkingManager(ParkingLot parkingLot) {
        return visit("\t", parkingLot);
    }

    @Override
    public String visitSelf(ParkingManager parkingManager) {
        return visit("", parkingManager);
    }
    
    @Override
    public String visitSelf(ParkingAgent parkingAgent) {
        return visit("\t", parkingAgent);
    }

    @Override
    public String visitSelfInParkingAgent(ParkingLot parkingLot) {
        return visit("\t\t", parkingLot);
    }

}
