package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leet111 {
    //BFS
    //T:O(n)
    //S:O(n)
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }

    //DFS
    //T:O(n)
    //S:O(n)?
    public int minDepth2(TreeNode root) {
        if (root == null)	return 0;
        if (root.left == null)	return minDepth2(root.right) + 1;
        if (root.right == null) return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left),minDepth2(root.right)) + 1;//both left and right are not null, return the min depth + 1
    }
}
