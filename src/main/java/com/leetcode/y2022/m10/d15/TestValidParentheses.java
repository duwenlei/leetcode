package com.leetcode.y2022.m10.d15;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效括号
 */
public class TestValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> dic = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            Character peek = stack.peek();
            if (dic.containsKey(peek) && dic.get(peek) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
