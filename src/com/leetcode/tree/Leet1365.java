package com.leetcode.tree;

import java.util.Arrays;

public class Leet1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int num : nums) count[num]++;//count frequency of elements in nums

        for (int i = 1 ; i <= 100; i++) count[i] += count[i - 1];//count how many elements <= current i

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0? 0: count[nums[i] - 1];// count[nums[i]] is how many elements <= nums[i], count[nums[i] - 1] is elements < nums[i]
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {8,1,2,2,3};
        int[] test2 = {6,5,4,8};
        int[] test3 = {7,7,7,7};
        Leet1365 leet = new Leet1365();
        System.out.println(Arrays.toString(leet.smallerNumbersThanCurrent(test1)));
        System.out.println(Arrays.toString(leet.smallerNumbersThanCurrent(test2)));
        System.out.println(Arrays.toString(leet.smallerNumbersThanCurrent(test3)));
    }
}
