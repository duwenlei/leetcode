package com.leetcode.y2022.m10.d18;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 中序便利
 *
 * @author duwenlei
 * @date 2022年10月18日 22:07
 */
public class TestBinaryInOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    public static void main(String[] args) {

    }
}
