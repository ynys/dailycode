package com.leetcode.tree;

public class Leet1480 {
    //Optimized 1- while
    //T: O(n)
    //S: O(1) - use the existing array

    public int[] runningSum2(int[] nums) {
        int i = 1;
        while (i<nums.length){
            nums[i]+=nums[i-1];
            i++;
        }
        return nums;
    }

    //Optimized 2 - for
    public int[] runningSum3(int[] nums){
        System.out.println(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            System.out.println(nums[i]);
        }
        return nums;
    }

    //My solution
    //T: O(n!) or O(n^2)
    //s: O(n)
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            int sum = nums[i];
            for(int j = 0; j < i; j++){
                sum += nums[j];
            }

            res[i] = sum;
            System.out.println(res[i]);
        }

        return res;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
       int[] nums2 = {1,1,1,1,1};
       int[] nums3 = {3,1,2,10,1};
       Leet1480 leet = new Leet1480();
       leet.runningSum3(nums);
       leet.runningSum3(nums2);
       leet.runningSum3(nums3);
    }
}
