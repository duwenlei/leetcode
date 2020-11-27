package com.leetcode.du20201127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duwenlei
 **/
public class FourSumCountVersion01 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = new HashMap<>(10);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                ans += mapAB.getOrDefault(-C[i] - D[j], 0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, -1};
        int[] b = new int[]{-1, 1};
        int[] c = new int[]{-1, 1};
        int[] d = new int[]{1, -1};
        System.out.println(fourSumCount(a, b, c, d));
    }
}
