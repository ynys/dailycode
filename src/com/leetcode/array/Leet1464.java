package com.leetcode.array;

import java.util.Arrays;

public class Leet1464 {
    //S2:
    //Time: O(n)
    //S: O(1)
    public int maxProduct2(int[] nums) {
        int m = Integer.MIN_VALUE, n = m;
        for (int num: nums) {
            if (num >= m) {
                n = m;
                m = num;
            }else if (num > n) {
                n = num;
            }
        }
        return (m - 1) * (n - 1);
    }

    //S1: sort and get the largest two
    //Time: O(nlogn)
    //S: O(1)
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {3,4,5,2};
        int[] nums2 = {1,5,4,5};

        Leet1464 leet = new Leet1464();
        System.out.println(leet.maxProduct(nums1));
        System.out.println(leet.maxProduct(nums2));
    }
}
