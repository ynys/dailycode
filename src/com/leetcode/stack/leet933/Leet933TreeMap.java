package com.leetcode.stack.leet933;

import java.util.TreeMap;

public class Leet933TreeMap {
    TreeMap<Integer, Integer> treeMap;

    public Leet933TreeMap() {
        treeMap = new TreeMap<>();
    }

    //T: O(logn)
    //S: O(n)
    public int ping(int t) {
        treeMap.put(t, 1 + treeMap.size());
        //tailMap(K fromKey)
        //Returns a view of the portion of this map whose keys are greater than or equal to fromKey.
        //tailMap(K fromKey, boolean inclusive)
        //Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey.
        return treeMap.tailMap(t - 3000).size();
    }

    public static void main(String[] args) {
        Leet933TreeMap leet933TreeMap = new Leet933TreeMap();

        System.out.println(leet933TreeMap.ping(1));
        System.out.println(leet933TreeMap.ping(100));
        System.out.println(leet933TreeMap.ping(3001));
        System.out.println(leet933TreeMap.ping(3002));
    }
}
