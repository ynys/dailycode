package com.leetcode.stack;

import java.util.Stack;

public class Leet155Stacks {
    private Stack<Integer> stack = new Stack<>();//stack features
    private Stack<Integer> minStack = new Stack<>();// only to save min in the stack top

    /** initialize your data structure here. */
    public Leet155Stacks() {

    }

    public void push(int x) {
        if(x <= getMin()){
            minStack.push(x);
        }

        stack.push(x);
    }

    public void pop() {
        if(stack.peek() == getMin()){
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minStack.peek();
        }
    }
}
