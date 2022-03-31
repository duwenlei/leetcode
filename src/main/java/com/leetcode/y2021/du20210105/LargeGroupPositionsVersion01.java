package com.leetcode.y2021.du20210105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duwenlei
 * <p>
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 **/
public class LargeGroupPositionsVersion01 {
    public static List<List<Integer>> largeGroupPositions(String s) {
        int start = 0;
        int end = 0;
        char idx = s.charAt(0);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == idx) {
                end = i;
            } else {
                if (end - start >= 2) {
                    ret.add(Arrays.asList(start, end));
                }
                start = i;
                idx = c;
            }
        }
        if (end - start >= 2) {
            ret.add(Arrays.asList(start, end));
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
    }
}
