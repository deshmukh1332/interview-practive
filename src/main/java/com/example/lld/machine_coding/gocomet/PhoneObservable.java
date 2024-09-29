package com.example.lld.machine_coding.gocomet;

import java.util.ArrayList;

public class PhoneObservable extends Observable {

    public PhoneObservable(Integer productId, Integer oldPrice) {
        this.productId = productId;
        this.oldPrice = oldPrice;
        this.observers = new ArrayList<>();
        this.newPrice = null;
        System.out.println("Product " + productId + " has been added to the list");
    }

    @Override
    public void addObserver(Observer observer) {
        System.out.println("User " + observer.userId + " has been subscribed to product " + productId);
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            if (observer.productThresholdMap.containsKey(productId)) {
                if (newPrice <= observer.productThresholdMap.get(productId) && observer.productThresholdMap.get(productId) <= oldPrice) {
                    observer.update();
                }
            }
        }
    }
}
