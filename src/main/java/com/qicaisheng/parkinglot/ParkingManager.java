package com.qicaisheng.parkinglot;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingManager implements ParkingResource {
    
    private List<ParkingAgent> managedParkingBoys = new ArrayList<>();

    public List<ParkingAgent> getManagedParkingBoys() {
        return managedParkingBoys;
    }

    public List<ParkingLot> getManagedParkingLots() {
        return managedParkingLots;
    }

    private List<ParkingLot> managedParkingLots;
    
    public ParkingManager(List<ParkingLot> parkingLots) {
        managedParkingLots = parkingLots;
    }

    @Override
    public String getShortName() {
        return "M";
    }

    @Override
    public int getAvailableSpaces() {
        return allManagedParkingLots().stream().mapToInt(ParkingLot::getAvailableSpaces).sum();
    }

    @Override
    public int getCapacity() {
        return allManagedParkingLots().stream().mapToInt(ParkingLot::getCapacity).sum();
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
