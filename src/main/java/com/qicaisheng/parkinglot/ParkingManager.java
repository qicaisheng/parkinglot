package com.qicaisheng.parkinglot;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingManager {
    
    private List<ParkingAgent> managedParkingBoys = new ArrayList<>();
    
    private List<ParkingLot> managedParkingLots;
    
    public ParkingManager(List<ParkingLot> parkingLots) {
        managedParkingLots = parkingLots;
    }

    public void manager(List<ParkingAgent> parkingBoys) {
        managedParkingBoys = parkingBoys;
    }

    public void park(Car car, ParkingLot parkingLot) throws ParkingLotFullException, WithoutManagedTheParkingBoyException {
        if (!managedParkingLots.contains(parkingLot)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        parkingLot.park(car);
    }

    public Car pick(Car car, ParkingLot parkingLot) throws ParkingLotWithoutTheCar, WithoutManagedTheParkingBoyException {
        if (!managedParkingLots.contains(parkingLot)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        return parkingLot.pick(car);
    }


    public void park(Car car, ParkingAgent parkingBoy) throws ParkingLotFullException, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        parkingBoy.park(car);
    }

    public Car pick(Car car, ParkingAgent parkingBoy) throws ParkingLotWithoutTheCar, WithoutManagedTheParkingBoyException {
        if (!managedParkingBoys.contains(parkingBoy)) {
            throw new WithoutManagedTheParkingBoyException();
        }
        return parkingBoy.pick(car);
    }
    
    public int availableParkingSpaces() {
        return allManagedParkingLots().stream().mapToInt(ParkingLot::availableSpaces).sum();
    }
    
    public int parkingCapacity() {
        return allManagedParkingLots().stream().mapToInt(ParkingLot::getCapacity).sum();
    }
    
    public String report() {
        String reportSelf = "M " + availableParkingSpaces() + " " + parkingCapacity() + "\n";
        String reportSelfManagedParkingLots = managedParkingLots.stream().map(parkingLot -> "\t" + parkingLot.report()).collect(Collectors.joining());
        String reportSelfManagedParkingAgents = managedParkingBoys.stream().map(parkingAgent -> "\t" + parkingAgent.report()).collect(Collectors.joining());
        
        return reportSelf + reportSelfManagedParkingLots + reportSelfManagedParkingAgents;
    }
    
    private List<ParkingLot> allManagedParkingLots() {
        List<ParkingLot> parkingLotsMangedByParkingBoys = managedParkingBoys
                .stream()
                .map(parkingAgent -> parkingAgent.managedParkingLots)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        Set<ParkingLot> parkingLots = new HashSet<>();
        parkingLots.addAll(managedParkingLots);
        parkingLots.addAll(parkingLotsMangedByParkingBoys);
        
        return new ArrayList<>(parkingLots);
    }
}
