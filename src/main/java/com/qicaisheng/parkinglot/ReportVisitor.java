package com.qicaisheng.parkinglot;

public abstract class ReportVisitor {
    public String visit(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String visitSelfInParkingManager(ParkingLot parkingLot);

    public abstract String visitSelf(ParkingManager parkingManager);
    
    public abstract String visitSelf(ParkingAgent parkingAgent);

    public abstract String visitSelfInParkingAgent(ParkingLot parkingLot);
}
