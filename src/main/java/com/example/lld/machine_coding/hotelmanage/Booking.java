package com.example.lld.machine_coding.hotelmanage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Booking {
    User user;
    List<Room> roomList;
    int amount;
    BookingStatus bookingStatus;
    Date checkInDate;
    Date checkOutDate;
    Date bookingDate;
    PaymentMethod paymentMethod;
    int numberOfGuests;

    public Booking(User user, List<Room> room, int price, PaymentMethod paymentMethod, int i) {
        this.user = user;
        this.roomList = new ArrayList<>(room);
        this.amount = price;
        this.paymentMethod = paymentMethod;
        this.numberOfGuests = i;
    }
}
