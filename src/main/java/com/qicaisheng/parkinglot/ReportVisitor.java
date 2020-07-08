package com.qicaisheng.parkinglot;

public abstract class ReportVisitor {
    private String from;

    public String visit(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String visitSelfInParkingManager(ParkingLot parkingLot);

    public abstract String visitSelf(ParkingManager parkingManager);
    
    public abstract String visitSelf(ParkingAgent parkingAgent);

    public abstract String visitSelfInParkingAgent(ParkingLot parkingLot);

    public String visitSelf(ParkingLot parkingLot) {
        if (getFrom().equals("ParkingManager")) {
            return visitSelfInParkingManager(parkingLot);
        } else {
            return visitSelfInParkingAgent(parkingLot);
        }
    }
    
    public void setFrom(String from) {
        this.from = from;
    };

    public String getFrom() {
        return from;
    }
}
