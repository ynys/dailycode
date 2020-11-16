package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Leet225OneQueue {
    private LinkedList<Integer> queue;

    public Leet225OneQueue(){
        queue = new LinkedList<>();
    }

    // Push element x onto stack.
    //T: O(n)
    //S: O(1), no extra
    public void push(int x)
    {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());//add elements to queue with reversed order
        }
    }

    // Removes the element on top of the stack.
    //T: O(1)
    //S: O(1)
    public int pop()
    {
        return queue.poll();
    }

    // Get the top element.
    //T: O(1)
    //S: O(1)
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    //T: O(1)
    //S: O(1)
    public boolean empty()
    {
        return queue.isEmpty();
    }
}
