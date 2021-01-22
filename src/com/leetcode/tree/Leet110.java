package com.leetcode.tree;

public class Leet110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;//return -1 immediately without proceeding to root.right

        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
