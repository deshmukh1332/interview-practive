package com.example.lld.machine_coding.groww;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParkingLot {
    private final Map<Integer, ParkingSpot> parkingSpotMap;
    private final Map<Integer, Ticket> ticketMap;
    private final Map<String, VehicleType> vehicleTypeMap;

    public ParkingLot(Map<String, Integer> vehicleTypeIntegerMap, Map<String, VehicleType> vehicleTypeMap) {
        this.vehicleTypeMap = vehicleTypeMap;
        this.ticketMap = new HashMap<>();
        this.parkingSpotMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : vehicleTypeIntegerMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                parkingSpotMap.put(parkingSpotMap.size() + 1, new ParkingSpot(parkingSpotMap.size() + 1, entry.getKey()));
            }
        }
    }

    public void displayParkingSpots() {
        System.out.println("Parking spots available: ");
        Map<String, Integer> parkingSpotCountMap = new HashMap<>();
        for (ParkingSpot parkingSpot : parkingSpotMap.values()) {
            if (parkingSpot.isOccupied()) {
                System.out.println("Parking spot: " + parkingSpot.getId() + " is occupied by vehicle: " + parkingSpot.getVehicle().getId());
            } else {
                System.out.println("Parking spot: " + parkingSpot.getId() + " is available for vehicle type: " + parkingSpot.getVehicle().getVehicleType().getName());
            }
            parkingSpotCountMap.put(parkingSpot.getVehicle().getVehicleType().getName(), parkingSpotCountMap.getOrDefault(parkingSpot.getVehicle().getVehicleType().getName(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : parkingSpotCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void exitVehicle(Integer ticketId, long exitTime) {

        System.out.println("Vehicle with ticket id: " + ticketId + " exited at: " + exitTime);
        Ticket ticket = ticketMap.get(ticketId);
        displayParkingSpots();
        System.out.println("Ticket details: " + ticket.getId() + " " + ticket.getEntryTime() + " " + ticket.getParkingSpotId());
        ParkingSpot parkingSpot = parkingSpotMap.get(ticket.getParkingSpotId());
        parkingSpot.unsetParkingSpotForVehicle(parkingSpot.getVehicle());
        ticket.setExitTime(exitTime);
        long duration = exitTime - ticket.getEntryTime();
        int hours = getHoursFromMillis(duration);
        System.out.println("Hours parked: " + hours);
        double amount = hours <= 1 ? parkingSpot.getVehicle().getVehicleType().getFixed() :
                        parkingSpot.getVehicle().getVehicleType().getFixed() + (hours - 1) * parkingSpot.getVehicle().getVehicleType().getVariable();
        System.out.println("Amount to be paid: " + amount);
        ticket.setAmount(amount);
    }

    private int getHoursFromMillis(long duration) {
        return (int) (duration / (1000 * 60 * 60));
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        displayParkingSpots();
        long entryTime = System.currentTimeMillis();
        return issueTicket(vehicle, entryTime);
    }

    public Ticket issueTicket(Vehicle vehicle, long entryTime) {
        List<ParkingSpot> availableSpots = getAvailableSpots(vehicle.getVehicleType().getName());
        if (availableSpots.isEmpty()) {
            return null;
        }
        ParkingSpot parkingSpot = availableSpots.get(0);
        if (parkingSpot == null) {
            System.out.println("No parking spot available for vehicle type: " + vehicle.getVehicleType());
            return null;
        }
        parkingSpot.setParkingSpotForVehicle(vehicle);
        Ticket ticket = new Ticket(ticketMap.size() + 1, vehicle.getId(), parkingSpot.getId(), entryTime);
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public List<ParkingSpot> getAvailableSpots(String vehicleType) {
        return parkingSpotMap.values().stream()
                   .filter(spot -> !spot.isOccupied() && Objects.equals(spot.getSpotType(), vehicleType))
                   .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsForVehicle(String vehicleId) {
        return ticketMap.values().stream().filter(ticket -> ticket.getVehicleId().equals(vehicleId)).collect(Collectors.toList());
    }

    public Map<String, VehicleType> getVehicleTypeMap() {
        return vehicleTypeMap;
    }
}
