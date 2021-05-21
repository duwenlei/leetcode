package com.leetcode.y2021.m04.d26;

/**
 * @author duwenlei
 **/
public class BSTSearch {
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

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
           return searchBST(root.left,val);
        } else if (root.val < val) {
            return searchBST(root.right,val);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6, n3, n4);
        TreeNode n1 = new TreeNode(4);
        TreeNode root = new TreeNode(5, n1, n2);

        TreeNode result = BSTSearch.searchBST(root, 6);
        System.out.println(result.val);

    }
}
