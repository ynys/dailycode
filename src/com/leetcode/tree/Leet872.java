package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leet872 {
    //S1: use list + recursive
    //T: O(T1+T2), T1/2: nodes of tree
    //S: O(T1+T2)
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValue){
        if(node != null){
            //check if current node is a leaf
            if(node.left == null && node.right == null){
                leafValue.add(node.val);
            }

            dfs(node.left, leafValue);
            dfs(node.right, leafValue);
        }
    }

    //S2: Stack, compare each leaf in two trees
    //TODO: to understand better
    //Better space complexity
    //T:
    //O(T1(Height) + T2(Height))
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty())
            if (dfs(s1) != dfs(s2)) return false;
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }

    public static void main(String[] args) {
// Initializing a list of type Linkedlist
        List<Integer> l = new LinkedList<>();
        l.add(10);
        l.add(20);// change order,
        l.add(15);
        System.out.println(l);

        // Initializing another list
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(10);
        l2.add(15);
        l2.add(20);
        System.out.println(l2);

        if (l.equals(l2))
            System.out.println("Equal");
        else
            System.out.println("Not equal");
    }
}
