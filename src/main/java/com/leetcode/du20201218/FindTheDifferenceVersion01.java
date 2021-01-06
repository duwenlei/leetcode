package com.leetcode.du20201218;

/**
 * @author duwenlei
 **/
public class FindTheDifferenceVersion01 {
    public static char findTheDifference(String s, String t) {
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        int idx = 0;
        while (idx < s.length() || idx < t.length()) {
            if (idx < s.length()) {
                ++s1[s.charAt(idx) - 'a'];
            }

            if (idx < t.length()) {
                ++t1[t.charAt(idx) - 'a'];
            }
            idx++;
        }
        char ret = ' ';
        int i = 0, j = 0;
        while (i < 26 || j < 26) {
            if (t1[i] > s1[i]) {
                ret = (char) ('a' + i);
                break;
            }
            i++;
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("aa", "aae"));
    }
}
