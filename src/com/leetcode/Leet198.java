package com.leetcode;

import java.util.Arrays;

//198. House Robber
public class Leet198 {
    public static void main(String[] args) {
        Leet198 l = new Leet198();
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};

        System.out.println(l.rob(nums1));
        System.out.println(l.rob(nums2));
    }

    //S1: Recursive + memo (top-down).
    //rob from the last house
    //Time: O(n)
    //S: O(n)
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        return rob(nums,nums.length - 1 );
    }

    //rob house i, return profit
    private int rob(int[] nums, int i){
        if(i < 0) return 0;
        if(memo[i] > 0) return memo[i]; //return the calculated

        //memo new one
        memo[i]  = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        return memo[i];
    }

    //S2:Iterative + memo (bottom-up) - array - TODO: need to understand
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    //S3:Iterative + memo (bottom-up): two variables - TODO: need to understand
    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

        //wrong
    public int rob1(int[] nums) {
        int odd = 0;
        int even = 0;

        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0) {
                even += nums[i];
            }
            else {
                odd += nums[i];
            }
        }

        return Math.max(even, odd);
    }



}
