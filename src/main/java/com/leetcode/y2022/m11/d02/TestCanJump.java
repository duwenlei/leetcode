package com.leetcode.y2022.m11.d02;

/**
 * 55
 *
 * @author duwenlei
 * @version 1.0
 * @className TestCanJump
 * @date 2022/11/2 16:22
 */
public class TestCanJump {

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int jumpC = nums[i];
            if ((i + jumpC) < nums.length - 1 && nums[i + jumpC] == 0) {
                return false;
            }
            i = i + jumpC;
        }
        return true;
    }

    public static void main(String[] args) {
        TestCanJump testCanJump = new TestCanJump();
        System.out.println(testCanJump.canJump(new int[]{3, 2, 1, 0, 4}));
        ;
    }
}
