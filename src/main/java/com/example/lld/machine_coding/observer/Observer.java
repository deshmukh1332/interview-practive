package com.example.lld.machine_coding.observer;

import java.util.Map;

public abstract class Observer {
    public Integer userId;
    public Map<Integer, Integer> productThresholdMap;
    public abstract void update();
}
