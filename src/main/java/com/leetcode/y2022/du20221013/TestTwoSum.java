package com.leetcode.y2022.du20221013;

import java.util.Arrays;

public class TestTwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(a, 9);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
