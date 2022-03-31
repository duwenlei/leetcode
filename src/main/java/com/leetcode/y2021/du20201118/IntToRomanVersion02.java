package com.leetcode.y2021.du20201118;

/**
 * @author duwenlei
 **/
public class IntToRomanVersion02 {
    /**
     * 贪心算法实现
     *
     * @param num 整数 1-3999
     * @return
     */
    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num = num - nums[i];
                sb.append(lm[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(5));
    }
}
