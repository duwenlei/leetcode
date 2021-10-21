package com.leetcode.y2021.m10.plus;

import java.util.Arrays;

/**
 * @author duwenlei
 **/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] ints = plusOne(digits);
        Arrays.stream(ints).forEach(System.out::println);
    }

    private static int[] plusOne(int[] digits) {
        int[] newDigits = new int[0];
        int idx = digits.length - 1;
        int carry = 0;
        while (idx >= 0) {
            int num = digits[idx];
            if (idx == digits.length - 1 || carry == 1) {
                num++;
                if (num == 10) {
                    digits[idx] = 0;
                    carry = 1;
                    if (idx == 0) {
                        // 创建一个比 digits 长的数组 newDigits
                        newDigits = new int[digits.length + 1];
                        newDigits[0] = 1;
                        newDigits[1] = 0;

                        // 将 digits 后面的值赋值给 newDigits
                        for (int i = 2; i < digits.length; i++) {
                            newDigits[i] = digits[i - 1];
                        }
                    }
                } else {
                    digits[idx] = num;
                    break;
                }
            }
            idx--;
        }
        return newDigits.length == digits.length + 1 ? newDigits : digits;
    }


}
