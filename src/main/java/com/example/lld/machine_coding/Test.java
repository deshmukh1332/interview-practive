package com.example.lld.machine_coding;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,3,8,3,5};
        System.out.println(Arrays.toString(maximumProfit(arr)));
    }

    private static int[] maximumProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            if (min > j) {
                min = j;
                minIndex = i;
            }
            if (ans < j-min) {
                ans = j-min;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex, ans};
    }
}
