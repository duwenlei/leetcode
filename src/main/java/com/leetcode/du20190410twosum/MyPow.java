package com.leetcode.du20190410twosum;

public class MyPow {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
        System.out.println(pow.myPow(2.10000, 3));
    }
}
