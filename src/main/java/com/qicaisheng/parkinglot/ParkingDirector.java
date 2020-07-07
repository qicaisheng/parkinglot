package com.qicaisheng.parkinglot;

public class ParkingDirector {
    
    private ParkingManager managedParkingManager;
    
    public void manage(ParkingManager parkingManager) {
        managedParkingManager = parkingManager;
    }

    public String getTextReport() {
        return new TextReportFactory().report(managedParkingManager);
    }

    public String getMarkdownReport() {
        return new MarkdownReportFactory().report(managedParkingManager);
    }

}
