package com.leetcode.tree;

import java.util.Stack;

public class Leet938 {
    //DFS
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        // count root in.
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        // left child is a possible candidate, means between root and low, there might be a node in the range
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        // right child is a possible candidate: between root and high, might be a node in the range
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }


    //BFS
    public int rangeSumBST2(TreeNode root, int low, int high) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int sum = 0;
        while (!stk.isEmpty()) {
            TreeNode n = stk.pop();
            if (n == null) { continue; }
            if (n.val > low) { stk.push(n.left); } // left child is a possible candidate.
            if (n.val < high) { stk.push(n.right); } // right child is a possible candidate.
            if (low <= n.val && n.val <= high) { sum += n.val; }
        }
        return sum;
    }

    public static void main(String[] args) {
        //you can push null to stack/pop null from
        Stack<TreeNode> stk = new Stack<>();
        stk.push(null);
        stk.push(null);
        stk.push(null);
        stk.push(null);
        System.out.println(stk.empty());
        System.out.println(stk.size());
        stk.pop();
        System.out.println(stk.size());
    }
}
