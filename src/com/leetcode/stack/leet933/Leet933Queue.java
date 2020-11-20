package com.leetcode.stack.leet933;

import java.util.LinkedList;
import java.util.Queue;

public class Leet933Queue {
    Queue<Integer> q;

    public Leet933Queue() {
        q = new LinkedList<>();
    }

    //Time: O(1), in the past 3000ms
    //S: O(1)
    public int ping(int t) {
        q.offer(t);
        //if t is out of range, poll it, we only interested in element >= t - 3000, which are in the queue currently
        while (q.peek() < t - 3000) { q.poll(); }
        return q.size();
    }
}
