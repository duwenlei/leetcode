package com.leetcode.y2022.du20220321;

public class BSTSearch {
    /**
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        return each(root, root, k);
    }

    public static boolean search(TreeNode node, TreeNode searchNode, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val && node != searchNode) {
            return true;
        }
        return node.val > val ? search(node.left, searchNode, val) : search(node.right, searchNode, val);
    }

    public static boolean each(TreeNode allNode, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int searchK = k - root.val;
        if (search(allNode, root, searchK)) {
            return true;
        }
        return each(allNode, root.left, k) || each(allNode, root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode s1_r = new TreeNode(3);
        root.right = s1_r;

        BSTSearch search = new BSTSearch();
        System.out.println(search.findTarget(root, 6));
    }
}
