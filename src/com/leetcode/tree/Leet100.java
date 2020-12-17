package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leet100 {
    //Recursive
    //T: O(n)
    //S:O(logn)-> completely balanced tree
    //O(n), completely unbalanced tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    //Iteration - use one queue
    //T: O(n)
    //S: O(n)?
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) {
                continue;
            }else if(t1 == null || t2 == null || t1.val != t2.val){
                return false;
            }

            queue.add(t1.left);
            queue.add(t1.left);
            queue.add(t1.right);
            queue.add(t2.right);

        }

        return true;
    }
}
