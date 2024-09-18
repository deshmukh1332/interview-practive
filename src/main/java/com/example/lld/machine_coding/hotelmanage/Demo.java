package com.example.lld.machine_coding.hotelmanage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.addRoom(new SingleRoom(101, 1000));
        hotel.addRoom(new SingleRoom(102, 1000));
        hotel.addRoom(new DoubleRoom(201, 2000));
        hotel.addRoom(new DoubleRoom(202, 2000));

        User user1 = new User("User1", 1234567890);
        User user2 = new User("User2", 1234567890);

        hotel.availableRooms(hotel);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> hotel.bookRoom(user2, 101, "2021-09-01", "2021-09-05"));
        executor.submit(() -> hotel.bookRoom(user1, 101, "2021-09-01", "2021-09-05"));

        executor.shutdown(); // Initiates an orderly shutdown

        hotel.checkout(user1, 101, PaymentMethod.CARD);
        hotel.checkout(user2, 201, PaymentMethod.CASH);
    }
}
