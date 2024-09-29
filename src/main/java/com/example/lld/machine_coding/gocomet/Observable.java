package com.example.lld.machine_coding.gocomet;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    public List<Observer> observers;
    public Integer productId;
    public Integer oldPrice;
    public Integer newPrice;
    public abstract void addObserver(Observer observer);
    public abstract void removeObserver(Observer observer);
    public abstract void notifyObservers();
}
