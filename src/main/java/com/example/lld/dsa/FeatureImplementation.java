package com.example.lld.dsa;

import java.util.Arrays;

public class FeatureImplementation {

    public static int getMinTime(int[] developmentTime, int[] integrationTime) {
        int n = developmentTime.length;

        // Calculate the total integration time if all features are integrated
        int totalIntegrationTime = 0;
        for (int time : integrationTime) {
            totalIntegrationTime += time;
        }

        // Initialize minimum time with the case where all features are integrated
        int minTime = totalIntegrationTime;

        // Evaluate the time if we decide to develop each feature from scratch
//        for (int i = 0; i < n; i++) {
//            int development = developmentTime[i];
//            int integration = totalIntegrationTime - integrationTime[i];
//            if (development <)
//        }

        return minTime;
    }

    public static void main(String[] args) {
        int[] developmentTime = {10, 12, 13, 8, 15};
        int[] integrationTime = {1, 2, 1, 1, 1};

        developmentTime = new int[]{1, 2, 5, 7};
        //sum of development time = 15
        integrationTime = new int[]{1, 3, 1, 3};
        //sum of integration time = 8

//        developmentTime = new int[]{3, 4, 5, 9};
        //sum of development time = 21
//        integrationTime = new int[]{3, 2, 5, 5};
        //sum of integration time = 15

        int minTime = getMinTime(developmentTime, integrationTime);
        System.out.println("Minimum time required: " + minTime);
    }
}