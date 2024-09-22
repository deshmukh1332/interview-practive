package com.example.lld.dsa;

public class M2P {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 7, 4};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }

    private static int maxProfit(int[] arr) {
        int ans = 0;
        int minLeft = arr[0];
        for (int j : arr) {
            if (j < minLeft) {
                minLeft = j;
            }
            ans = Math.max(ans, j - minLeft);
        }
        return 0;
    }


}
