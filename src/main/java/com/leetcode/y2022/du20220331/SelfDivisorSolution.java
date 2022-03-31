package com.leetcode.y2022.du20220331;

import java.util.ArrayList;
import java.util.List;

public class SelfDivisorSolution {
    public static void main(String[] args) {
        List<Integer> integers = selfDividingNumbers(1, 22);
        integers.stream().forEach(System.out::println);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int tmp = i;
            boolean bool = Boolean.TRUE;
            while (true) {
                if (tmp % 10 == 0){
                    bool = false;
                    break;
                }
                if (tmp / 10 == 0) {
                    if (i % tmp != 0) {
                        bool = false;
                    }
                    break;
                } else {
                    if (i % (tmp % 10) != 0) {
                        bool = false;
                    }
                }
                tmp = tmp / 10;
            }
            if (bool) {
                res.add(i);
            }
        }
        return res;
    }
}
