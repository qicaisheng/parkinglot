package com.qicaisheng.parkinglot;

public abstract class ParkingResource {

    public String getSelfReportData(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }

    public abstract String getShortName();

    public abstract int getAvailableSpaces();

    public abstract int getCapacity();

}
