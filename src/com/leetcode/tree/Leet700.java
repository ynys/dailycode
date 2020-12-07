package com.leetcode.tree;

public class Leet700 {
    //recursive
    //Use BST attribute
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val== val) return root;
        return val < root.val? searchBST(root.left, val) : searchBST(root.right, val);
    }

    //iteration
    public TreeNode searchBST2(TreeNode root, int val) {
        //keep searching if root.val != val
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
