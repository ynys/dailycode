package com.leetcode.array;

public class Leet1304 {
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
}
