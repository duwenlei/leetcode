package com.leetcode.y2021.du20190410;

public class SamePrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <1){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"fllower", "fllow", "fllight"};
        SamePrefix samePrefix = new SamePrefix();
        String prefix = samePrefix.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
