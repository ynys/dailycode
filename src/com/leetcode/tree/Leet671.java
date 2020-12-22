package com.leetcode.tree;

public class Leet671 {
    //s1
    //T: O(n)
    //S: O(h), h is the the tree height, worst case h = n
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        // if value is same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    //s2: concise version
    public int findSecondMinimumValue2(TreeNode root) {
        if(root==null)  return -1;
        return findSecondMinValue(root, root.val);
    }


    public int findSecondMinValue(TreeNode root, int min) {
        if(root==null)  return -1;
        if(root.val>min)   return root.val;
        int leftMin = findSecondMinValue(root.left,min);
        int rightMin = findSecondMinValue(root.right,min);
        return (leftMin==-1 || rightMin==-1) ? Math.max(leftMin,rightMin) : Math.min(leftMin,rightMin);
    }
}
