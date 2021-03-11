package com.leetcode.array;

public class Leet1304 {
    //S1: find rule
    //T: O(n)
    //S: O(n)
    public int[] sumZero(int n) {
        //come up with a formula
        //A[i] = i * 2 - n + 1
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }

    //S2: fill up from both left and right side
    //T: O(n)
    //S: O(n)
    public int[] sumZero2(int n) {
        int[] res = new int[n];
        int left = 0, right = n - 1, start = 1;
        while (left < right) {
            res[left++] = start;
            res[right--] = -start;
            start++;
        }
        return res;
    }
}
