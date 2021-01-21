package com.leetcode.tree;

public class Leet572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSameTree(s,t)) return true;
        //check s.left and right
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //this funcation is same as Leet 100
    private boolean isSameTree(TreeNode t1, TreeNode t2){
       if(t1 == null && t2 == null) return true;
       if(t1 == null || t2 == null) return false;
       if(t1.val != t2.val) return false;

       return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
