package com.leetcode.y2021.du20190415;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int addNum1 = nums[i];
                int addNum2 = nums[j];
                int difference = 0 - (addNum1 + addNum2);
                if (numsMap.containsKey(difference)) {
                    ans.add(Arrays.asList(addNum1, addNum2, difference));
                    System.out.printf("匹配的数字组合：%d\t%d\t%d", addNum1, addNum2, difference);
                    System.out.println();
                    System.out.printf("匹配数字的下标：%d\t %d\t%d", i, j, numsMap.get(difference));
                    System.out.println();
                    System.out.println("-------------------------------------");
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> ans = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ans.toString());
    }
}
