package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < index.length; i++){
            res.add(index[i], nums[i]);
            //Inserts the specified element at the specified position in this list (optional operation).
            //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Leet1389 leet = new Leet1389();
        int[] nums1 = {0,1,2,3,4};
        int[] index1 = {0,1,2,2,1};

        int[] nums2 = {1,2,3,4,0};
        int[] index2 = {0,1,2,3,0};

        System.out.println(Arrays.toString(leet.createTargetArray(nums1,index1)));
        System.out.println(Arrays.toString(leet.createTargetArray(nums2,index2)));

//        List<String> list = new ArrayList<>(5);
//
//        // use add() method to initially
//        // add elements in the list
//        list.add("Geeks");
//        list.add("For");
//        list.add("Geeks");
//
//        // Add a new element at index 0
//        list.add(0, "Hello");
//        list.add(0, "Hello2");
//        list.add(0, "Hello3");
//
//        // prints all the elements available in list
//        for (String str : list) {
//            System.out.print(str + " ");
//        }
    }
}
