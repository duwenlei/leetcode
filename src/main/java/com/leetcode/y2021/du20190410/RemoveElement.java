package com.leetcode.y2021.du20190410;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
        int val = 3;
//        RemoveElement r = new RemoveElement();
//        System.out.println(r.removeElement(nums, val));
    }
}
