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

    public String report(ReportFactory reportFactory) {
        if (reportFactory instanceof TextReportFactory) {
            return getTextReport();
        }
        if (reportFactory instanceof MarkdownReportFactory) {
            return getMarkdownReport();
        }
        return null;
    }
}
