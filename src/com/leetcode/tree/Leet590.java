package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leet590 {
    //iterative
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            res.addFirst(root.val);

            //process current root's children
            for(Node node: root.children){
                stack.push(node);
            }
        }

        return res;
    }


    //recursive
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder2(Node root) {
        if (root == null)
            return list;

        for(Node node: root.children)
            postorder(node);

        list.add(root.val);

        return list;
    }
}
