package com.qicaisheng.parkinglot;

public class ParkingDirector {
    
    private ParkingManager managedParkingManager;
    
    public void manage(ParkingManager parkingManager) {
        managedParkingManager = parkingManager;
    }

    public String report(ReportFactory reportFactory) {
        if (reportFactory instanceof TextReportFactory) {
            return new TextReportFactory().report(managedParkingManager);
        }
        if (reportFactory instanceof MarkdownReportFactory) {
            return new MarkdownReportFactory().report(managedParkingManager);
        }
        return null;
    }
}
