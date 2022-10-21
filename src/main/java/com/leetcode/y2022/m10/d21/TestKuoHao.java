package com.leetcode.y2022.m10.d21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duwenlei
 * @date 2022年10月21日 13:52
 */
public class TestKuoHao {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recur(0, 0, n, "", ans);
        return ans;
    }

    private void recur(int left, int right, int n, String s, List<String> ans) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            recur(left + 1, right, n, s + "(", ans);
        }
        if (right < left) {
            recur(left, right + 1, n, s + ")", ans);
        }
    }

    public static void main(String[] args) {
        TestKuoHao t = new TestKuoHao();
        List<String> strings = t.generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
