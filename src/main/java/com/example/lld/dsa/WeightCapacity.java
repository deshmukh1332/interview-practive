package com.example.lld.dsa;

import java.util.Arrays;

public class WeightCapacity {
    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 10, 7, 6};
        int kthLargest = 2;
        int d = 3;
        System.out.println(leastWeightCapacity(arr, d));
    }

    private static int leastWeightCapacity(int[] weights, int d) {
        int total = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();
        int r = total;
        int currentLeastCapacity = 0, ans = Integer.MAX_VALUE;
        while (l < r) {
            currentLeastCapacity = l + (r - l) / 2;
            int countOfDays = getCountOfDays(weights, currentLeastCapacity);

            if (countOfDays <= d) {
                ans = Math.min(ans, currentLeastCapacity);
                r = currentLeastCapacity;
            } else {
                l = currentLeastCapacity + 1;
            }
        }
        return ans;
    }

    private static int getCountOfDays(int[] weights, int currentLeastCapacity) {
        int countOfDays = 0;
        int currentWeightInDay = 0;
        for (int weight : weights) {
            if (currentWeightInDay + weight > currentLeastCapacity) {
                currentWeightInDay = 0;
                countOfDays++;
            }
            currentWeightInDay += weight;
        }
        return countOfDays + 1;
    }
}
