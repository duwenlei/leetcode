package com.leetcode.y2022.m10.d26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duwenlei
 * @version 1.0
 * @className TestSolveNQueens
 * @date 2022/10/26 10:26
 */
public class TestSolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        final ArrayList<String> list = new ArrayList<>();
        dfs(ans, n, 0, list, cols, pies, nas);
        return ans;
    }

    private void dfs(List<List<String>> ans, int n, int level, ArrayList<String> list, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas) {
        // terminator
        if (level >= n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // process
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(level + col) || nas.contains(level - col)) {
                continue;
            }

            cols.add(col);
            pies.add(level + col);
            nas.add(level - col);
            list.add(col + "");

            // drill down
            dfs(ans, n, level + 1, list, cols, pies, nas);

            // reverse state
            cols.remove(col);
            pies.remove(level + col);
            nas.remove(level - col);
        }
    }

    public static void main(String[] args) {
        TestSolveNQueens queens = new TestSolveNQueens();
        final List<List<String>> lists = queens.solveNQueens(8);
        lists.forEach(System.out::println);
    }
}
