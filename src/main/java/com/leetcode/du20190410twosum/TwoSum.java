package com.leetcode.du20190410twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        long startTime = System.currentTimeMillis();
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.printf("[%d,%d]", result[0], result[1]);
        System.out.println("时间消耗：" + (endTime - startTime));
    }
}
