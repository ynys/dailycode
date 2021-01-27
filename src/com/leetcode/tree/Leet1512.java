package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet1512 {
    //S1: map
    //T:O(n^2)?
    //S:O(n)
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);

            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int count = entry.getValue().size();
            pairs += count * (count - 1)/2;//组合数
        }

        return pairs;
    }

    //S2: map, one loop
    //T: O(n), n is the length of nums, worst case: elements in nums are unique
    //S: O(n) ? max length
    public int numIdenticalPairs2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            res += map.get(n) - 1;

        }

        //example:{1,1,1,1}
        //k,v; res
        //1st loop: 1, 1; 1-1 = 0
        //2nd: 1,2; 0+2-1 = 1
        //3nd: 1,3; 1 + 3 - 1 = 3
        //4th: 1,4; 3+ 4 - 1 = 6
        return res;
    }

    //S3: count array -> similar as S2: map
    //T: O(n)
    //S: O(1), constant count array? or O(n) n is the max length
    public int numIdenticalPairs3(int[] A) {
        int res = 0;
        int[] count = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        //https://stackoverflow.com/questions/2371118/how-do-the-post-increment-i-and-pre-increment-i-operators-work-in-java
        // a, count[a], res, count[a]++,
        //1, 0, 0,       1
        //1, 1, 0+1 = 1, 2
        //1, 2, 1+2 = 3, 3
        //1, 3, 3+3 = 6, 4
        //note: count[a]++, we should use original count[a] to calculate then count[a]++
        return res;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,1,1,3};//4
        int[] t2 = {1,1,1,1};//6
        int[] t3 = {1,2,3};//0

        Leet1512 leet = new Leet1512();
        System.out.println(leet.numIdenticalPairs(t1));
        System.out.println(leet.numIdenticalPairs2(t1));
        System.out.println(leet.numIdenticalPairs3(t1));
        System.out.println(leet.numIdenticalPairs(t2));
        System.out.println(leet.numIdenticalPairs2(t2));
        System.out.println(leet.numIdenticalPairs3(t2));
        System.out.println(leet.numIdenticalPairs(t3));
        System.out.println(leet.numIdenticalPairs2(t3));
        System.out.println(leet.numIdenticalPairs3(t3));
    }
}
