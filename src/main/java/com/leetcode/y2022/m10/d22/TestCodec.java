package com.leetcode.y2022.m10.d22;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author duwenlei
 * @date 2022年10月22日 8:27
 */
public class TestCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root, "");
    }

    private String preOrder(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        } else {
            s += root.val + ",";
            s = preOrder(root.left, s);
            s = preOrder(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(linkedList);
    }

    private TreeNode rdeserialize(LinkedList<String> linkedList) {
        if (linkedList.get(0).equals("None")) {
            linkedList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(linkedList.get(0)));
        linkedList.remove(0);
        root.left = rdeserialize(linkedList);
        root.right = rdeserialize(linkedList);
        return root;
    }

    public static void main(String[] args) {

        TreeNode t4 = new TreeNode(4);
        TreeNode t1 = new TreeNode(3, t4, null);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1, t2, t1);
        TestCodec c = new TestCodec();
        String serialize = c.serialize(t3);
        System.out.println(serialize);
    }

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
}
