package com.leetcode.y2022.m11.d02;

import java.util.Arrays;

/**
 * 455
 *
 * @author duwenlei
 * @version 1.0
 * @className TestGreedy
 * @date 2022/11/2 14:48
 */
public class TestGreedy {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0) {
            return 0;
        }

        if (s == null || s.length == 0) {
            return 0;
        }
        // g, s 排序
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        // 贪心计算
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TestGreedy testGreedy = new TestGreedy();
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{3, 2};
        int contentChildren = testGreedy.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
