package com.example.lld.machine_coding.hotelmanage;

public class User {
    String name;

    int phoneNumber;

    public User(String user1, int i) {
        System.out.println("User created successfully " + user1);
        this.name = user1;
        this.phoneNumber = i;
    }
}
