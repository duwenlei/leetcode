package com.leetcode.du20201207;

/**
 * @author duwenlei
 **/
public class MatrixScoreVersion {
    public static int matrixScore(int[][] A) {
        // 先反转行
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }

        // 在反转列
        int length = A[0].length;
        for (int i = 0; i < length; i++) {
            int index = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 0) {
                    index++;
                }
            }

            if (index > 0 && A.length < index * 2) {
                for (int j = 0; j < A.length; j++) {
                    if (A[j][i] == 0) {
                        A[j][i] = 1;
                    } else {
                        A[j][i] = 0;
                    }
                }
            }
        }

        // 计算和
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ret += A[i][j] << (A[i].length - j - 1);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int i = matrixScore(A);
        System.out.println(i);
    }
}
