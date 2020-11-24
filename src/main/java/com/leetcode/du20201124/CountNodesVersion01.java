package com.leetcode.du20201124;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duwenlei
 **/
public class CountNodesVersion01 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countNodes(TreeNode root) {
        AtomicInteger a = new AtomicInteger(0);
        countNode(a, root);
        return a.get();
    }

    private static void countNode(AtomicInteger a, TreeNode node) {
        if (node == null) {
            return;
        }
        a.incrementAndGet();
        countNode(a, node.left);
        countNode(a, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);

        int i = countNodes(root);
        System.out.println(i);
    }
}
