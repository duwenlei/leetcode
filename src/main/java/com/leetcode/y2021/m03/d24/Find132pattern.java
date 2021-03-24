package com.leetcode.y2021.m03.d24;

/**
 * @author duwenlei
 **/
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 2 >= nums.length) {
                break;
            }
            int j = i + 1;
            int k = i + 2;

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, -4, -3};
        Find132pattern find132pattern = new Find132pattern();
        System.out.println(find132pattern.find132pattern(arr));
    }
}
