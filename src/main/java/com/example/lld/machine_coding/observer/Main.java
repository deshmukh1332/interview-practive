package com.example.lld.machine_coding.observer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monitoring monitoring = new Monitoring();
        UserObserver userObserver1 = new UserObserver(1);
        UserObserver userObserver2 = new UserObserver(2);
        UserObserver userObserver3 = new UserObserver(3);
        List<Observable> observableList = monitoring.getObservableList();
        observableList.add(new PhoneObservable(1, 1000));
        observableList.add(new PhoneObservable(2, 2000));

        List<Observer> observerList = monitoring.getObserverList();
        for (Observable observable : observableList) {
            observable.addObserver(userObserver1);
            observerList.add(userObserver1);
            observable.addObserver(userObserver2);
            observerList.add(userObserver2);
            observable.addObserver(userObserver3);
            observerList.add(userObserver3);
        }

        monitoring.addUserPreference(1, 1, 900);
        monitoring.addUserPreference(2, 2, 1900);
        monitoring.addUserPreference(3, 1, 800);

        monitoring.updatePrice(1, 850);
        monitoring.updatePrice(1, 750);
        monitoring.updatePrice(1, 2000);
        monitoring.updatePrice(1, 600);
        monitoring.updatePrice(1, 850);
        monitoring.updatePrice(1, 550);

        List<Alert> alertList = monitoring.getAlertList();
        for (Alert alert : alertList) {
            System.out.println(alert.getUserId() + " " + alert.getProductId() + " " + alert.getNewPrice());
        }
    }
}
