package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet107 {
    //BFS
    //T: O(n), n is the node number
    //S: O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) return res;

        queue.offer(root);

        while(!queue.isEmpty()){
            int levelElementsNum = queue.size();
            List<Integer> levelElementsList = new LinkedList<>();
            //add elements in the level list
            for(int i = 0; i < levelElementsNum; i++){
                //add elements for next level
                TreeNode head = queue.peek();
                if(head.left != null) queue.offer(head.left);
                if(head.right != null) queue.offer(head.right);
                //add current level elements
                levelElementsList.add(queue.poll().val);
            }

            //add level list to the front of the res list in order to have bottom up result
            res.add(0, levelElementsList);
        }

        return res;
    }

    //DFS
    //TODO: need to understand better
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
