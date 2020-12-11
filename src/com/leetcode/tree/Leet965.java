package com.leetcode.tree;

public class Leet965 {
    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) &&
                (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}
