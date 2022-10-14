package com.leetcode.y2022.du20221013;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class TestThereSum {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -1, -4};

        // 先排序
        Arrays.sort(nums);

        // 双指针 k,i,j
        // k 为 -(i+j)

        //List<Integer> a;
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (s < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {// s == 0
                    ans.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i < j && nums[j] == nums[--j]) ;
                    while (i < j && nums[i] == nums[++i]) ;
                }
            }
        }

        ans.stream().forEach(System.out::println);
    }
}
