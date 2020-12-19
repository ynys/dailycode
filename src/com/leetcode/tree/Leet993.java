package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leet993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isXExist = false;
            boolean isYExist = false;

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                //if x and y in the same depth, both should be true
                if(cur.val == x) isXExist = true;
                if(cur.val == y) isYExist = true;

                //check if x and y have same parent
                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y){
                        return false;
                    }

                    if(cur.left.val == y && cur.right.val == x){
                        return false;
                    }
                }

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

            if(isXExist && isYExist){
                return true;
            }else if(isXExist || isYExist){//not in the same level, return false
                return false;
            }
        }

        return false;
    }
}
