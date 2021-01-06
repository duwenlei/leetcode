package com.leetcode.du20210105;

import java.util.ArrayList;
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
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(start);
                    integers.add(end);
                    ret.add(integers);
                }
                start = i;
                idx = c;
            }
        }
        if (end - start >= 2) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(start);
            integers.add(end);
            ret.add(integers);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
    }
}
