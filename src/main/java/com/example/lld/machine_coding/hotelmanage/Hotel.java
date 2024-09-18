package com.example.lld.machine_coding.hotelmanage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Hotel {
    final Map<Integer, Room> roomMap = new HashMap<>();

    final Map<String, Booking> bookingList = new ConcurrentHashMap<>();

    public void addRoom(SingleRoom singleRoom) {
        System.out.println("Room added " + singleRoom.type);
        roomMap.put(singleRoom.roomNumber, singleRoom);
    }

    public void addRoom(DoubleRoom doubleRoom) {
        System.out.println("Room added " + doubleRoom.type);
        roomMap.put(doubleRoom.roomNumber, doubleRoom);
    }

    public synchronized void bookRoom(User user, int roomNumber, String date, String date1) {
        // Simulating some delay to mimic concurrency issues
        System.out.println(user.name + " is trying to book room " + roomNumber);
        try {
            Thread.sleep(1000); // Simulate a delay in booking process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (roomMap.containsKey(roomNumber)) {
            // Room already booked
            System.out.printf("Room %d is already booked by %s%n", roomNumber, bookingList.values().stream()
                       .filter(booking -> booking.roomList.stream().anyMatch(room -> room.roomNumber == roomNumber))
                       .findFirst().get().user.name);
        } else {
            // Room is available, proceed to book
            Room room = roomMap.get(roomNumber);
            room.bookRoom(user, date, date1);

            Booking booking = new Booking(user, Collections.singletonList(room), room.price, PaymentMethod.CARD, 1);
            String bookingId = UUID.randomUUID().toString();
            bookingList.put(bookingId, booking);
            System.out.println(user + " successfully booked room " + roomNumber);
        }
    }

    public void checkIn(User user1, int i, PaymentMethod paymentMethod) {

    }

    public void checkout(User user1, int i, PaymentMethod paymentMethod) {

    }

    public void availableRooms(Hotel hotel) {
        System.out.println("Available rooms are: ");
        hotel.roomMap.values().forEach(room -> {
            if (room.roomStatus == RoomStatus.AVAILABLE) {
                System.out.println(room.roomNumber);
            }
        });
    }
}
