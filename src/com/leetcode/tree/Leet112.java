package com.leetcode.tree;

public class Leet112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;//no need to do the next recursion since this is a leaf

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
