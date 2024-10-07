package com.example.lld.dsa;


public class DPMaxDiff {
    static boolean ans = false;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 15, 233, 7};
        System.out.println(predictTheWinner(arr));
    }

    private static boolean playerWin(int[] arr) {
        int player1 = 0, player2 = 0;
        int currPlayer = 1;
        int l = 0, r = arr.length - 1;
        helperFun(arr, player1, player2, currPlayer, l, r);
        return ans;
    }

    private static void helperFun(int[] arr, int player1, int player2, int current, int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r && player1 >= player2) {
            ans = true;
        }
        if (current == 1) {
            current = 2;
            if (player1 + arr[l] > player2) {
                helperFun(arr, player1 + arr[l], player2, current, l + 1, r);
            } else {
                helperFun(arr, player1 + arr[r], player2, current, l, r - 1);
            }
        } else {
            current = 1;
            if (player2 + arr[l] > arr[r]) {
                helperFun(arr, player1, player2 + arr[l], current, l + 1, r);
            } else {
                helperFun(arr, player1, player2 + arr[r], current, l, r - 1);
            }
        }
    }

    public static boolean predictTheWinner(int[] nums) {
        return maxDifference(nums, 0, nums.length - 1) >= 0;
    }

    // Recursive function to calculate the max score difference for Player 1
    private static int maxDifference(int[] nums, int i, int j) {
        // Base case: if there's only one element left, Player 1 takes it
        if (i == j) {
            return nums[i];
        }

        // Player 1 has two choices:
        // 1. Take nums[i], and then Player 2 will play optimally on the remaining nums[i+1...j]
        // 2. Take nums[j], and then Player 2 will play optimally on the remaining nums[i...j-1]

        int chooseLeft = nums[i] - maxDifference(nums, i + 1, j);
        int chooseRight = nums[j] - maxDifference(nums, i, j - 1);

        // Return the option that maximizes Player 1's score difference
        return Math.max(chooseLeft, chooseRight);
    }
}
