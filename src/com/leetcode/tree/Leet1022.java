package com.leetcode.tree;

public class Leet1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    //TODO: need to understand better
    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}
