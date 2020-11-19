package com.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet496 {
    public static void main(String[] args) {
        Leet496 leet = new Leet496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        leet.nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(leet.nextGreaterElement(nums1,nums2)));

        int[] nums11 = {2,4};
        int[] nums22 = {1,2,3,4};
        leet.nextGreaterElement(nums11,nums22);
        System.out.println(Arrays.toString(leet.nextGreaterElement(nums11,nums22)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
