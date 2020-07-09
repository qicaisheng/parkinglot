package com.qicaisheng.parkinglot;

public class HTMLReportVisitor extends ReportVisitor {
    @Override
    public String visitFromParkingManager(ParkingLot parkingLot) {
        return visit("h3", parkingLot);
    }

    @Override
    public String visit(ParkingManager parkingManager) {
        return visit("h2", parkingManager);
    }

    @Override
    public String visit(ParkingAgent parkingAgent) {
        return visit("h3", parkingAgent);
    }

    @Override
    public String visitFromParkingAgent(ParkingLot parkingLot) {
        return visit("div", parkingLot);
    }

    public String visit(String block, ParkingResource parkingResource) {
        return "<" + block + ">" + contentOf(parkingResource) + "</" + block + ">";
    }

    private String contentOf(ParkingResource parkingResource) {
        return parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity();
    }

}
