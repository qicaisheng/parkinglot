package com.qicaisheng.parkinglot;

public abstract class ReportFactory {
    public String report(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String report(ParkingManager parkingManager);
}
