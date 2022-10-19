package com.leetcode.y2022.m10.d19;

/**
 * 爬楼梯，递归
 *
 * @author duwenlei
 * @date 2022年10月19日 22:12
 */
public class TestClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
