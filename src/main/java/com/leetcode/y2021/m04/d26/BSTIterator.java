package com.leetcode.y2021.m04.d26;

import java.util.ArrayList;

/**
 * 二叉树迭代器
 *
 * @author duwenlei
 **/
public class BSTIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int idx;
    private ArrayList<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderBST(root, arr);
    }

    private void inorderBST(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderBST(root.left, arr);
        arr.add(root.val);
        inorderBST(root.right, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return arr.size() > idx;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6, n3, n4);
        TreeNode n1 = new TreeNode(4);
        TreeNode root = new TreeNode(5, n1, n2);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
