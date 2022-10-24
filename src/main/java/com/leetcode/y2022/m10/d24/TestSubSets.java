package com.leetcode.y2022.m10.d24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duwenlei
 * @date 2022年10月24日 16:12
 */
public class TestSubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(ans, list, nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 需要这位数
        list.add(nums[start]);
        backtrack(ans, list, nums, start + 1);

        // 不需要这位数
        list.remove(list.size() - 1);
        backtrack(ans, list, nums, start + 1);
    }

    public static void main(String[] args) {
        TestSubSets subSets = new TestSubSets();
        List<List<Integer>> subsets = subSets.subsets(new int[]{1, 2, 3});
        subsets.forEach(integers -> {
            integers.forEach(System.out::print);
            System.out.println();
        });
    }
}
