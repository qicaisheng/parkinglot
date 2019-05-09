package com.qicaisheng.parkinglot;

public class ParkingDirector {
    
    private ParkingManager managedParkingManager;
    
    public void manage(ParkingManager parkingManager) {
        managedParkingManager = parkingManager;
    }

    public String report() {
        return ReportFactory.report(managedParkingManager);
    }

    public String getMarkdownReport() {
        return ReportFactory.getMarkdownReport(managedParkingManager);
    }

}
