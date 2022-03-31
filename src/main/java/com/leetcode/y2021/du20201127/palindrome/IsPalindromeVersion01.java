package com.leetcode.y2021.du20201127.palindrome;

/**
 * 回文数判断
 *
 * @author duwenlei
 **/
public class IsPalindromeVersion01 {
    /**
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || x >= Integer.MAX_VALUE) {
            return false;
        }
        int oldX = x;
        // 1、判断 x 的位数
        int newX = 0;
        while (x != 0) {
            newX = newX * 10 + (x % 10);
            x /= 10;
        }
        System.out.println(oldX + "\t" + newX);
        if (oldX == newX) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
