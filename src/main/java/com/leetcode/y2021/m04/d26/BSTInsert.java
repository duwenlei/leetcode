package com.leetcode.y2021.m04.d26;

/**
 * @author duwenlei
 **/
public class BSTInsert {
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

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.val < val) {
                    if (temp.right == null) {
                        temp.right = new TreeNode(val);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6, n3, n4);
        TreeNode n1 = new TreeNode(4);
        TreeNode root = new TreeNode(5, n1, n2);
        TreeNode result = BSTInsert.insertIntoBST(root, 1);
        System.out.println(result.val);
    }


}
