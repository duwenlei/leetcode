package com.leetcode.y2021.du20201119;

import java.util.Arrays;

/**
 * @author duwenlei
 **/
public class MoveZeroesVersion01 {
    /**
     * 垃圾代码
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int[] nums2 = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums2[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
