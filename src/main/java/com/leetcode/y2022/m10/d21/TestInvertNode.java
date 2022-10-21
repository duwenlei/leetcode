package com.leetcode.y2022.m10.d21;

import com.leetcode.y2022.m10.d20.TestValidBinaryTree;

/**
 * @author duwenlei
 * @date 2022年10月21日 14:43
 */
public class TestInvertNode {
    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }

    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        recur(root.left);
        recur(root.right);
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
