package com.leetcode.array;

public class Leet1534 {
    //Time: O(n^3)
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < n -2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                // check if satisfy then loop for k
                if(Math.abs(arr[i] - arr[j]) <= a) {
                    for(int k = j + 1; k < n; k++) {
                        if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                            count++;
                    }
                }
            }
        }

        return count;
    }
}
