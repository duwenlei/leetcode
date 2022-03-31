package com.leetcode.y2021.du20210105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duwenlei
 * <p>
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 **/
public class LargeGroupPositionsVersion02 {
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0, j = 0; i < s.length(); i = j) {
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                ret.add(Arrays.asList(i, j - 1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
    }
}
