package com.example.lld.dsa;

public class Combinations {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1};
        int target = 3;
        System.out.println(combinations(arr, target));
    }

    private static int combinations(int[] arr, int target) {
        int sum = 0;
        for (int k : arr) {
            sum += k;
        }
        int[][] dp = new int[arr.length][2 * sum + 1];
        dp[0][sum - arr[0]] = 1;
        dp[0][sum + arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - arr[i] > 0 && j - arr[i] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
                if (j + arr[i] > 0 && j + arr[i] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + arr[i]];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[arr.length - 1][sum + target];
    }
}
