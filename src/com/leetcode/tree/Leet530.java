package com.leetcode.tree;

public class Leet530 {
    //S1: in order traverse
    //T: O(n)
    //S: O(h) height of the tree

    //这个是优化空间版本的方案，原始方案是用一个list存储inorder traverse的结果，然后凉凉比较找到最小，
    //改进方案是：用一个变量prev来存前一个值，这样就能再traverse的时候
    //花花：https://www.youtube.com/watch?v=0JHrHh_mIIw
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;

        getMinimumDifference(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
