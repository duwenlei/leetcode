package com.leetcode.y2021.du20201119;

import java.util.Arrays;

/**
 * @author duwenlei
 **/
public class MoveZeroesVersion02 {
    /**
     * 双指针
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int leftPoint = 0, rightPoint = 0;
        while (rightPoint < nums.length) {
            if (nums[rightPoint] != 0) {
                int tmpNum = nums[leftPoint];
                nums[leftPoint] = nums[rightPoint];
                nums[rightPoint] = tmpNum;
                leftPoint++;
            }
            rightPoint++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes1(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
