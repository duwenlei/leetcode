package com.leetcode.y2022.m10.d19;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成，递归
 *
 * @author duwenlei
 * @date 2022年10月19日 22:49
 */
public class TestGenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recur(0, 0, n, "", ans);
        return ans;
    }

    private void recur(int left, int right, int n, String s, List<String> ans) {
        // terminator
        if (left == n && left == right) {
            ans.add(s);
            return;
        }

        // process logic

        // drill down
        if (left < n) {
            recur(left + 1, right, n, s + "(", ans);
        }

        if (right < left) {
            recur(left, right + 1, n, s + ")", ans);
        }
        // recur state
    }

    public static void main(String[] args) {
        TestGenerateParenthesis t = new TestGenerateParenthesis();
        List<String> strings = t.generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
