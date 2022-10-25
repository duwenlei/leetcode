package com.leetcode.y2022.m10.d16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 异位词
 */
public class TestAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || "".equals(s) || "".equals(t)) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                Integer value = map.get(s.charAt(i));
                map.put(s.charAt(i), ++value);
            }
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), -1);
            } else {
                Integer value = map.get(t.charAt(i));
                map.put(t.charAt(i), --value);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("rat", "car"));
    }

}
