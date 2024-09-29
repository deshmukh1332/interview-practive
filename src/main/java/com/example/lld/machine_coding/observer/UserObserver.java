package com.example.lld.machine_coding.observer;

import java.util.HashMap;

public class UserObserver extends Observer {

    public UserObserver(Integer userId) {
        this.userId = userId;
        this.productThresholdMap = new HashMap<>();
        System.out.println("User " + userId + " has been subscribed");
    }

    @Override
    public void update() {
        System.out.println("User " + userId + " has been notified");
    }

}
