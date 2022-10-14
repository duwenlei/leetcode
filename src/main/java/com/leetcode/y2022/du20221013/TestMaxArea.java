package com.leetcode.y2022.du20221013;

/**
 * 盛水最多的容器
 */
public class TestMaxArea {
    /**
     * O(n^2)
     * @param a
     */
    public static void maxArea(int[] a) {
        int maxArea = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int area = Math.min(a[i], a[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println(maxArea);
    }


    /**
     * O(n)
     * @param a
     */
    public static void maxArea1(int[] a) {
        int maxArea = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHeight = a[i] > a[j] ? a[j--] : a[i++];
            int area = (j - i + 1) * minHeight;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(a);
        maxArea1(a);
    }
}
