package com.example.lld.dsa;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreading {
    static class DemoBlockedRunnable implements Runnable {
        @Override
        public void run() {
            commonResource();
        }

        public static synchronized void commonResource() {
            while(true) {
                // Infinite loop to mimic heavy processing
                // 't1' won't leave this method
                // when 't2' try to enter this

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable());
        Thread t2 = new Thread(new DemoBlockedRunnable());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.exit(0);
//        ThreadDemo t1 = new ThreadDemo("Thread-1");
//        t1.start();
//        ThreadDemo t2 = new ThreadDemo("Thread-2");
//        t2.start();
    }

    static class ThreadDemo implements Runnable {
        private final String threadName;

        ThreadDemo(String name) {
            threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            try {
                for (int i = 2; i > 0; i--) {
                    System.out.println("Thread: " + threadName + ", " + i);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
        }

        public void start() {
            Thread t = new Thread(this, this.threadName);
            t.start();
        }
    }
}
