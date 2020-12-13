package com.leetcode.tree;

public class Leet669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return root;
        }

        //val < low, scan root.right
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        //val > high, scan root.left

        if(root.val > high){
            return trimBST(root.left, low, high);
        }

        // in the range, keep scanning along the children
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
