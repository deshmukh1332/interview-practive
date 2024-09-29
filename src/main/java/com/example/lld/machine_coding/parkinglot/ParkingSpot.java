package com.example.lld.machine_coding.parkinglot;

public class ParkingSpot {
    private Integer id;
    private boolean isOccupied;
    private Vehicle vehicle;
    private Integer parkingLotId;
    private String spotType;

    public ParkingSpot(Integer id, String spotType) {
        this.id = id;
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public synchronized void setParkingSpotForVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public synchronized void unsetParkingSpotForVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public String getSpotType() {
        return spotType;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }
}
