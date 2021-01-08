package com.leetcode.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leet606 {
    //S1: recursion
    //T: O(n)
    //S: O(n)
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(t, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
        }
    }

    //S2:Stack
    //T:O(n)
    //S: O(n)
    public String tree2str2(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack< >();
        stack.push(t);
        Set< TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(").append(t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);//remove outer ()
    }
}
