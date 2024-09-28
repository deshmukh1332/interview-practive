package com.example.lld.machine_coding.groww;


public class Vehicle {
    private String id;
    private VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType, String licensePlate) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void removePark(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.setOccupied(false);
        parkingSpot.setVehicle(null);
    }
}
