package com.leetcode.y2022.m10.d25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duwenlei
 * @version 1.0
 * @className TestLetterCombinations
 * @date 2022/10/25 10:09
 */
public class TestLetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length()==0){
            return ans;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        helper(digits, 0, "", ans, map);
        return ans;
    }

    private void helper(String digits, int index, String s, List<String> ans, Map<Character, String> map) {
        if (index == digits.length()) {
            ans.add(s);
        } else {
            String letters = map.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                s += letters.charAt(i);
                helper(digits, index + 1, s, ans, map);
                // 删除上一个 helper 上的字母
                s = s.substring(0,index);
            }
        }
    }

    public static void main(String[] args) {
        TestLetterCombinations l = new TestLetterCombinations();
        final List<String> strings = l.letterCombinations("23");
        strings.forEach(System.out::println);
    }
}
