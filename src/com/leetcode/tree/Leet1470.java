package com.leetcode.tree;

import java.util.Arrays;

public class Leet1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i = 0; i < 2*n; i++){
            res[i] = (i%2 == 0)? nums[i/2]: nums[n + i/2];
        }

        return res;
    }

    public int[] shuffle2(int[] nums, int n){
        int[] res = new int[2*n];
        for(int i = 0; i < n; i++){
            //even <- 1st half of nums
            res[2 * i] = nums[i];
            //odd <- 2nd half of nums
            res[2 * i + 1] = nums[n+i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {2,5,1,3,4,7};
        int[] test2 = {1,2,3,4,4,3,2,1};
        int[] test3 = {1,1,2,2};
        Leet1470 leet = new Leet1470();
        System.out.println(Arrays.toString(leet.shuffle(test1,3)));
        System.out.println(Arrays.toString(leet.shuffle2(test1,3)));
        System.out.println(Arrays.toString(leet.shuffle(test2,4)));
        System.out.println(Arrays.toString(leet.shuffle2(test2,4)));
        System.out.println(Arrays.toString(leet.shuffle(test3,2)));
        System.out.println(Arrays.toString(leet.shuffle2(test3,2)));
    }
}
