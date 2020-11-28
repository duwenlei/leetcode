package com.leetcode.du20201128;

import java.math.BigInteger;

/**
 * @author duwenlei
 **/
public class ReversePairsVersion01 {
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                BigInteger bigInteger = new BigInteger(nums[j] + "");
                BigInteger temp = bigInteger.multiply(new BigInteger("2"));
                BigInteger numsi = new BigInteger(nums[i] + "");
                if (i < j && numsi.compareTo(temp) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        System.out.println(reversePairs(nums));
    }
}
