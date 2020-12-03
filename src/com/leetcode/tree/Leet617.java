package com.leetcode.tree;

public class Leet617 {
    //Recursive: use updated t1 as result
    //TIme: O(n), n nodes needed to be traversed,
    //S: O(n)?
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //Recursive: create new node
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode n= new TreeNode(t1.val+t2.val);
        n.left=mergeTrees(t1.left, t2.left);
        n.right=mergeTrees(t1.right, t2.right);
        return n;
    }

    //Iterative: TODO: to understand
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2){
        return null;
    }
}
