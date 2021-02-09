package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet1748 {
    //S1: map
    //T: O(n)
    //S: O(n) -> actual 1 <= nums[i] <= 100
    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int num: nums){
//            if(map.containsKey(num)){
//                map.put(num, map.get(num)+1);
//            }else {
//                map.put(num, 1);
//            }

           // map.put(num, map.getOrDefault(num, 0) + 1);

            map.merge(num, 1, Integer::sum);//sum function in Integer to take current value and new value to add
        }

//        for(Map.Entry<Integer, Integer> e: map.entrySet()){
//            if(e.getValue() == 1){
//                sum += e.getKey();
//            }
//        }

        for(int k: map.keySet()){
            if(map.get(k) == 1){
                sum += k;
            }
        }

        return sum;
    }

    //S2: similar as Map, use a fixed size array with size = 101
    //T: O(n)
    //S: O(1)
    public int sumOfUnique2(int[] nums) {
        int[] cnt = new int[101];
        int sum = 0;

        for (int n : nums) {
            ++cnt[n];
        }
        for (int i = 1; i <= 100; ++i) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        int[] nums1 = {1,1,1,1,1};
        int[] nums2 = {1,2,3,4,5};

        Leet1748 leet = new Leet1748();
        System.out.println(leet.sumOfUnique(nums));
        System.out.println(leet.sumOfUnique2(nums));
        System.out.println(leet.sumOfUnique(nums1));
        System.out.println(leet.sumOfUnique2(nums1));
        System.out.println(leet.sumOfUnique(nums2));
        System.out.println(leet.sumOfUnique2(nums2));
    }
}
