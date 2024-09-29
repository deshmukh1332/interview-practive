package com.example.lld.machine_coding.gocomet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Monitoring {
    private List<Observable> observableList;
    private List<Observer> observerList;
    private List<Alert> alertList;

    public List<Observable> getObservableList() {
        return observableList;
    }
    public List<Observer> getObserverList() {
        return observerList;
    }
    public Monitoring() {
        this.observerList = new ArrayList<>();
        this.observableList = new ArrayList<>();
        this.alertList = new ArrayList<>();
    }

    public void addObservable(Observable observable) {
        observableList.add(observable);
    }

    public void updatePrice(Integer productId, Integer newPrice) {
        for (Observable observable : observableList) {
            if (Objects.equals(observable.productId, productId)) {
                observable.newPrice = newPrice;
                System.out.println("Price of product " + productId + " has been decreased to " + newPrice);
                if (observable.newPrice < observable.oldPrice) {
                    observable.notifyObservers();
                }
                observable.oldPrice = observable.newPrice;
            }
        }
    }

    public void addUserPreference(Integer userId, Integer productId, Integer threshold) {
        this.getObserverList().stream().filter(observer -> Objects.equals(observer.userId, userId))
            .forEach(observer -> observer.productThresholdMap.putIfAbsent(productId, threshold));
        System.out.println("User " + userId + " has set the threshold for product " + productId + " to " + threshold);
    }


    public void setAlert(Integer userId, Integer productId, Integer newPrice) {
        alertList.add(new Alert(userId, productId, newPrice));
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

}
