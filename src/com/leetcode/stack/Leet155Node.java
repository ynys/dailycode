package com.leetcode.stack;

import java.util.Stack;

public class Leet155Node {
    private Node head;
    public void push(int x) {
        if(head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);//create new node and point it's next to previous node, point head to new node
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    //head.min always save the newest min
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
