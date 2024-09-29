package com.example.lld.machine_coding.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");
        Map<String, Integer> vehicleTypeIntegerMap = new HashMap<>();
        vehicleTypeIntegerMap.put("CAR", 5);
        vehicleTypeIntegerMap.put("BIKE", 5);
        vehicleTypeIntegerMap.put("TRUCK", 5);

        Map<String, VehicleType> vehicleTypeMap = new HashMap<>();
        vehicleTypeMap.put("CAR", new VehicleType(20, 10, "CAR"));
        vehicleTypeMap.put("BIKE", new VehicleType(10, 5, "BIKE"));
        vehicleTypeMap.put("TRUCK", new VehicleType(30, 20, "TRUCK"));

        ParkingLot parkingLot1 = new ParkingLot(vehicleTypeIntegerMap, vehicleTypeMap);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", vehicleTypeMap.get("CAR"));
        Vehicle vehicle2 = new Vehicle("KA-01-HH-1235", vehicleTypeMap.get("CAR"));
        Vehicle vehicle3 = new Vehicle("KA-01-HH-1236", vehicleTypeMap.get("BIKE"));
        Vehicle vehicle4 = new Vehicle("KA-01-HH-1237", vehicleTypeMap.get("TRUCK"));

        System.out.println("Parking Spots available for CAR: " + parkingLot1.getAvailableSpots("CAR")
                                                                     .stream().map(ParkingSpot::getId).collect(Collectors.toList()));
        System.out.println("Parking Spots available for Bike: " + parkingLot1.getAvailableSpots("BIKE")
                                                                      .stream().map(ParkingSpot::getId).collect(Collectors.toList()));
        System.out.println("Parking Spots available for Truck: " + parkingLot1.getAvailableSpots("TRUCK")
                                                                       .stream().map(ParkingSpot::getId).collect(Collectors.toList()));
        Ticket ticket1 = parkingLot1.parkVehicle(vehicle1);
        Ticket ticket2 = parkingLot1.parkVehicle(vehicle2);
        Ticket ticket3 = parkingLot1.parkVehicle(vehicle3);
        Ticket ticket4 = parkingLot1.parkVehicle(vehicle4);

        System.out.println("Parking Spots available for Truck: " + parkingLot1.getAvailableSpots("TRUCK")
                                                                     .stream().map(ParkingSpot::getId).collect(Collectors.toList()));

        parkingLot1.exitVehicle(ticket1.getId(), System.currentTimeMillis());
        parkingLot1.exitVehicle(ticket2.getId(), System.currentTimeMillis());
        parkingLot1.exitVehicle(ticket3.getId(), System.currentTimeMillis());
        parkingLot1.exitVehicle(ticket4.getId(), System.currentTimeMillis());

        System.out.println("Parking Spots available for Car: " + parkingLot1.getAvailableSpots("CAR"));

        parkingLot1.displayParkingSpots();
        parkingLot1.getTicketsForVehicle(vehicle1.getId()).forEach(ticket -> System.out.println(ticket.getId() + " " + (ticket.getExitTime() - ticket.getEntryTime()) + " " + ticket.getAmount()));
    }
}
