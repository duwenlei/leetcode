package com.leetcode.y2022.m10.d20;

/**
 * @author duwenlei
 * @date 2022年10月20日 17:36
 */
public class TestValidBinaryTree {

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, Long left, Long right) {
        if (node == null) {
            return true;
        }
        if (node.val <= left || node.val >= right) {
            return false;
        }
        return valid(node.left,left, (long) node.val) && valid(node.right, (long) node.val,right);
    }

    public class TreeNode {
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

}
