package com.leetcode.y2021.du20201203;

/**
 * @author duwenlei
 **/
public class CountPrimesVersion01 {
    public static int countPrimes(int n) {
        int max = 0;
        for (int i = 2; i < n; i++) {
            max += isPrimes(i) ? 1 : 0;
        }
        return max;
    }

    private static boolean isPrimes(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
