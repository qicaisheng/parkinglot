package com.qicaisheng.parkinglot;

import java.util.stream.Collectors;

public class TextReportVisitor extends ReportVisitor {
    
    @Override
    public String visitFromParkingManager(ParkingLot parkingLot) {
        return visit("\t", parkingLot);
    }

    @Override
    public String visit(ParkingManager parkingManager) {
        return visit("", parkingManager);
    }
    
    @Override
    public String visit(ParkingAgent parkingAgent) {
        return visit("\t", parkingAgent);
    }

    @Override
    public String visitFromParkingAgent(ParkingLot parkingLot) {
        return visit("\t\t", parkingLot);
    }

}
