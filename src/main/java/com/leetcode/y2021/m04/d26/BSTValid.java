package com.leetcode.y2021.m04.d26;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉搜索树认证
 *
 * @author duwenlei
 **/


public class BSTValid {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    public static void main(String[] args) {
//        TreeNode n4 = new TreeNode(7);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(6, n3, n4);
//        TreeNode n1 = new TreeNode(1);
//        TreeNode root = new TreeNode(5, n1, n2);
        TreeNode n4 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6, n3, n4);
        TreeNode n1 = new TreeNode(4);
        TreeNode root = new TreeNode(5, n1, n2);

        BSTValid bstValid = new BSTValid();
        System.out.println(bstValid.isValidBST(root));
    }
}
