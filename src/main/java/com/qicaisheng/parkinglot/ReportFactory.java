package com.qicaisheng.parkinglot;

public abstract class ReportFactory {
    public static String getSelfReportData(String prefix, ParkingResource parkingResource) {
        return prefix + parkingResource.getShortName() + " " + parkingResource.getAvailableSpaces() + " " + parkingResource.getCapacity() + "\n";
    }
}
