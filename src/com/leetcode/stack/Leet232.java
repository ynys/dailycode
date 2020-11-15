package com.leetcode.stack;

import java.util.Stack;

//232. Implement Queue using Stacks
public class Leet232 {
    public static void main(String[] args) {
        Leet232 queue = new Leet232();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    private Stack<Integer> s1 = new Stack<>();// bottom of s1 is the front of Queue
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    /** Initialize your data structure here. */
//    public MyQueue() {
//
//    }

    /** Push element x to the back of queue. */
    //T: O(1)
    //S: O(n)
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }

        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    //Time complexity: Amortized O(1), Worst-case O(n).
    //Space complexity : O(1)

    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }

        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
