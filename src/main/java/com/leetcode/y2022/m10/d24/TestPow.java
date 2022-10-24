package com.leetcode.y2022.m10.d24;

/**
 * @author duwenlei
 * @date 2022年10月24日 12:35
 */
public class TestPow {
    public double myPow(double x, int n) {
        return n >= 0 ? fastPow(x, n) : 1.0 / fastPow(x, -n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double pow = fastPow(x, n / 2);
        return n % 2 == 0 ? pow * pow : pow * pow * x;
    }
}
