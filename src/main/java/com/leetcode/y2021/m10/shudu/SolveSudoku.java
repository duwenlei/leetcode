package com.leetcode.y2021.m10.shudu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duwenlei
 **/
public class SolveSudoku {
    public static void main(String[] args) {
        System.out.println('5');
        System.out.println('0');
        System.out.println('1');
        System.out.println((int)('5'-'0'));

        char[][] borad = {
                {'.', '7', '6', '.', '.', '.', '8', '.', '.'},
                {'.', '.', '8', '6', '.', '.', '5', '2', '.'},
                {'9', '.', '.', '.', '4', '.', '.', '7', '.'},
                {'5', '.', '.', '7', '.', '.', '6', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '7', '.', '.'},
                {'.', '1', '.', '.', '6', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '3', '.', '.', '8', '5'},
                {'8', '.', '5', '1', '.', '.', '.', '.', '.'},
                {'.', '4', '.', '.', '5', '2', '.', '.', '1'}
        };
        solveSudoku(borad);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(borad[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static boolean[][] line = new boolean[9][9];
    private static boolean[][] column = new boolean[9][9];
    private static boolean[][][] block = new boolean[3][3][9];
    private static List<int[]> spaces = new ArrayList<>();
    private static boolean valid = false;

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);

    }

    public static void dfs(char[][] board, int pos) {
        if (spaces.size() == pos) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
