package com.leetcode.y2022.m10.d18;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 *
 * 前序便利
 *
 * @author duwenlei
 * @date 2022年10月18日 22:14
 */
public class TestBinaryPreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }
}
