package com.leetcode.y2021.m10.majority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * @author duwenlei
 **/
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> ans = majorityElement(nums);
    }

    private static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (counter.containsKey(nums[i])) {
                counter.put(nums[i], counter.get(nums[i]) + 1);
            } else {
                counter.put(nums[i], 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer key : counter.keySet()) {
            if (counter.get(key) > nums.length / 3) {
                ans.add(key);
            }
        }
        return ans;
    }
}
