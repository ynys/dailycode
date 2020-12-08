package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet589 {
    //Iterative
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return  res;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);

            //push children from right to left to the stack
            for(int i = root.children.size() - 1; i >= 0; i--){
                stack.push(root.children.get(i));
            }
        }

        return res;
    }

    //recursive
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        if (root == null)
            return list;

        list.add(root.val);//add root first
        for(Node node: root.children)
            preorder(node);

        return list;
    }
}
