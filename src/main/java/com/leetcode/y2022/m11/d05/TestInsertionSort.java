package com.leetcode.y2022.m11.d05;

import java.util.Arrays;

/**
 * @author duwenlei
 * @version 1.0
 * @className TestInsertionSort
 * @date 2022/11/5 8:34
 */
public class TestInsertionSort {


    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            int t = arr[i];
            while (k > 0 && t < arr[k - 1]) {
                arr[k] = arr[k - 1];
                k--;
            }
            if (k != i) {
                arr[k] = t;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        TestInsertionSort insertionSort = new TestInsertionSort();
        int[] ints = insertionSort.insertionSort(new int[]{5, 69, 8, 4,4, 7, 12, 56, 36, 98});
        Arrays.stream(ints).forEach(System.out::println);
    }
}