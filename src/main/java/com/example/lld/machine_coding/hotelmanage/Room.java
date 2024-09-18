package com.example.lld.machine_coding.hotelmanage;

abstract class Room {
    String type;
    int roomNumber;
    RoomStatus roomStatus;
    int price;

    public synchronized void bookRoom(User user1, String date, String date1) {
        if (roomStatus == RoomStatus.BOOKED) {
            System.out.println("Room is already booked for " + user1.name + " from " + date + " to " + date1);
            return;
        }
        roomStatus = RoomStatus.BOOKED;
        System.out.println("Room booked successfully for " + user1.name + " from " + date + " to " + date1);
    }
}
