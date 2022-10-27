package com.leetcode.y2022.m10.d27;

/**
 * @author duwenlei
 * @version 1.0
 * @className TestArraySign
 * @date 2022/10/27 8:22
 */
public class TestArraySign {
    public int arraySign(int[] nums) {
        long res = product(nums, 0, 1);
        return Long.compare(res, 0);
    }

    private long product(int[] nums, int level, long product) {
        if (level == nums.length || product == 0) {
            return product;
        }
        return product(nums, level + 1, Long.compare(product * nums[level], 0));
    }

    public static void main(String[] args) {
        TestArraySign arraySign = new TestArraySign();
        System.out.println(arraySign.arraySign(new int[]{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24}));
    }
}
