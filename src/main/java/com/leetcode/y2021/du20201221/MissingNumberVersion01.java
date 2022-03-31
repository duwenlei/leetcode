package com.leetcode.y2021.du20201221;

/**
 * @author duwenlei
 **/
public class MissingNumberVersion01 {
    public static int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 3};
        System.out.println(missingNumber(ints));
    }
}
