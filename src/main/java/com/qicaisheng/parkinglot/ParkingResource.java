package com.qicaisheng.parkinglot;

public abstract class ParkingResource {

    public String getSelfReportData(String prefix) {
        return prefix + getShortName() + " " + getAvailableSpaces() + " " + getCapacity() + "\n";
    }

    public abstract String getShortName();

    public abstract int getAvailableSpaces();

    public abstract int getCapacity();

}
