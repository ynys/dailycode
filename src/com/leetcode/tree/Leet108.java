package com.leetcode.tree;

public class Leet108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high){
        if(low > high) return null;

        //use mid element as the root of the current tree
        int mid = (high - low)/2 + low;//avoid overflow
        TreeNode node = new TreeNode(nums[mid]);
        //find the mid of the left half and use it as the left node
        node.left = helper(nums, low, mid - 1);

        //same for the right
        node.right = helper(nums,mid+1, high);

        return node;
    }
}
