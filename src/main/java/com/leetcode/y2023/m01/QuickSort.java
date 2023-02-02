package com.leetcode.y2023.m01;

import java.util.Arrays;

/**
 * @author duwenlei
 * @version 1.0
 * @className QuickSort
 * @date 2023/2/2 9:58
 */
public class QuickSort {

    public void quickSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        int pivotIdx = doublePointerSwap(arr, startIdx, endIdx);

        // pivotIdx = 1 才对
        quickSort(arr, startIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, endIdx);
    }

    private int doublePointerSwap(int[] arr, int startIdx, int endIdx) {
        int pivot = arr[startIdx];
        int leftPoint = startIdx;
        int rightPoint = endIdx;

        while (leftPoint < rightPoint) {
            while (leftPoint < rightPoint && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            while (leftPoint < rightPoint && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            if (leftPoint < rightPoint) {
                int temp = arr[leftPoint];
                arr[leftPoint] = arr[rightPoint];
                arr[rightPoint] = temp;
            }
        }
        arr[startIdx] = arr[rightPoint];
        arr[rightPoint] = pivot;
        return rightPoint;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {4, 3, 8, 7};
        quickSort.quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }
}
