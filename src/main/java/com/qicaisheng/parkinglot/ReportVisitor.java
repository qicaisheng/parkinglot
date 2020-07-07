package com.qicaisheng.parkinglot;

public abstract class ReportVisitor {
    public String visit(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String visit(ParkingManager parkingManager);

    public abstract String visit(ParkingAgent parkingAgent);
}
