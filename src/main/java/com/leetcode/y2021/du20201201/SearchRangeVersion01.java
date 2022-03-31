package com.leetcode.y2021.du20201201;

import java.util.Arrays;

/**
 * @author duwenlei
 **/
public class SearchRangeVersion01 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }

        int i = 0, j = nums.length - 1;

        int retI = -1;
        int retJ = -1;

        boolean flagI = true;
        boolean flagJ = true;
        while (i <= j && (flagI || flagJ)) {
            if (nums[i] != target && flagI) {
                i++;
            } else {
                retI = i;
                flagI = false;
            }

            if (nums[j] != target && flagJ) {
                j--;
            } else {
                retJ = j;
                flagJ = false;
            }

        }
        return new int[]{retI, retJ};
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5,7,7,8,8,10}, 8);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
