package com.qicaisheng.parkinglot;

public abstract class ReportVisitor {
    private String from;

    public String visit(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String visitFromParkingManager(ParkingLot parkingLot);

    public abstract String visit(ParkingManager parkingManager);
    
    public abstract String visit(ParkingAgent parkingAgent);

    public abstract String visitFromParkingAgent(ParkingLot parkingLot);

    public String visit(ParkingLot parkingLot) {
        if (getFrom().equals("ParkingManager")) {
            return visitFromParkingManager(parkingLot);
        } else {
            return visitFromParkingAgent(parkingLot);
        }
    }
    
    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }
}
