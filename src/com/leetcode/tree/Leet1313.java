package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1313 {
    //S1: mine, use list and stream
    //n: pairs in nums
    //m: average freq for each value in pair
    //Time: O(n*m)
    //Space: O(n*m)
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                res.add(val);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    //S2: use Arrays.fill
    //n: pairs in nums
    //m: average freq for each value in pair
    //Time: O(n) + O(nm)
    //Space: O(nm)
    public int[] decompressRLElist2(int[] nums) {
        //count result array size
        int size = 0;
        for(int i = 0; i < nums.length; i+=2){
            size += nums[i];
        }

        //fill array with the current value with the start/end
        //fromIndex - the index of the first element (inclusive) to be filled with the specified value
        //toIndex - the index of the last element (exclusive) to be filled with the specified value
        int[] res = new int[size];
        int startIdx = 0;
        for(int i = 0; i < nums.length; i += 2){
            //freq = nums[i];
            //val = nums[i + 1];
            Arrays.fill(res,startIdx, startIdx+nums[i], nums[i + 1]);
            startIdx += nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Leet1313 leet = new Leet1313();

        int[] t1 = {1, 2, 3, 4};
        int[] t2 = {1, 1, 2, 3};

        System.out.println(Arrays.toString(leet.decompressRLElist(t1)));
        System.out.println(Arrays.toString(leet.decompressRLElist2(t1)));
        System.out.println(Arrays.toString(leet.decompressRLElist(t2)));
        System.out.println(Arrays.toString(leet.decompressRLElist2(t2)));
    }
}
