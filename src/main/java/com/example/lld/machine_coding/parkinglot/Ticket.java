package com.example.lld.machine_coding.parkinglot;

public class Ticket {
    private final Integer id;
    private final String vehicleId;
    private final Integer parkingSpotId;
    private Integer parkingLotId;
    private final long entryTime;
    private TicketStatus status;
    private long exitTime;
    private double amount;

    public Ticket(Integer id, String vehicleId, Integer parkingSpotId, long entryTime) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.parkingSpotId = parkingSpotId;
        this.entryTime = entryTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Integer getId() {
        return id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Integer getExitTime() {
        return (int) exitTime;
    }

    public Integer getAmount() {
        return (int) amount;
    }
}
