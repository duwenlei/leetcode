package com.leetcode.y2022.m10.d18;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * 后序遍历
 *
 * @author duwenlei
 * @date 2022年10月18日 22:20
 */
public class TestBinaryPostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    private void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }
}
