package com.leetcode.y2021.du20201218;

/**
 * @author duwenlei
 **/
public class FindTheDifferenceVersion02 {
    public static char findTheDifference(String s, String t) {
        int ss = 0, ts = 0;
        int i = 0, j = 0;
        while (i < s.length() || j < t.length()) {
            if (i < s.length()) {
                ss += s.charAt(i);
            }
            if (j < t.length()) {
                ts += t.charAt(j);
            }
            i++;
            j++;
        }
        return (char) (ts - ss);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("aa", "aae"));
    }
}
