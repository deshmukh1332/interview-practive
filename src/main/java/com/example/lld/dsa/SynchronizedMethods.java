package com.example.lld.dsa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedMethods {

    private int sum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    // standard setters and getters
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethods summation = new SynchronizedMethods();

        for (int count = 0; count < 1000; count++) {
            service.submit(summation::calculate);
        }
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        System.out.println(summation.getSum());
    }
}
