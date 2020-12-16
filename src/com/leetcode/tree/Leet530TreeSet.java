package com.leetcode.tree;

import java.util.TreeSet;

public class Leet530TreeSet {
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;

    //TreeSet
    //T: O(nlogn)
    //S: O(n)
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }

        set.add(root.val);

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }
}
