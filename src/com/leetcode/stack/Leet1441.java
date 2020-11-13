package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class Leet1441 {
    public static void main(String[] args) {
        Leet1441 leet = new Leet1441();
        int[] t1 = {1,3};
        int[] t2 = {1,2,3};
        int[] t3 = {1,2};
        int[] t4 = {2,3,4};
        System.out.println(leet.buildArray(t1, 3));
        System.out.println(leet.buildArray(t2, 3));
        System.out.println(leet.buildArray(t3, 4));
        System.out.println(leet.buildArray(t4, 4));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i=1;i<=n && j<target.length;i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }

}
