package com.leetcode.tree;

public class Leet563 {
    int result = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);

        return result;
    }

    private int postOrder(TreeNode root){
        if(root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        //return all sum from root's children + root
        return left + right + root.val;
    }
}
