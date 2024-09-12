package com.example.lld.dsa;

import java.awt.print.Pageable;
import java.util.Arrays;

public class BTree {
    public static void main(String[] args) {
        int k = 8;
        int[] a = {2, 3, 6, 2, 8};
        System.out.println(solution(k, a));
    }

    // find number of distinct pairs whose sum is k
    // 0 <= a[i] <= 10^9
    // 1 <= n <= 10^5
    // 1 <= k <= 10^9
    // optimal solution
    // time complexity: O(n)
    // space complexity: O(1)
    // answer should be 1 for the above input
    static int solution(int k, int[] a) {
        int count = 0;
        int[] freq = new int[1000001];
        for (int value : a) {
            freq[value]++;
        }
        for (int j : a) {
            if (k - j == j) {
                count--;
            }
            if (k - j >= 0 && freq[k - j] > 0) {
                count++;
            }
        }
        return count / 2;
    }
}
