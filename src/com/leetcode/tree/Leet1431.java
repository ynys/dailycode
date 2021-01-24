package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leet1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            //if (candy > greatest) greatest = candy;
            greatest = Math.max(candy,greatest);
        }

        for (int candy : candies) {
            res.add(candy + extraCandies >= greatest);
        }

        return res;
    }

    public static void main(String[] args) {
        Leet1431 leet = new Leet1431();
        int[] candies = {2,3,5,1,3};
        int[] candies1 = {4,2,1,1,2};
        int[] candies2 = {12,1,12};

        System.out.println(leet.kidsWithCandies(candies, 3));
        System.out.println(leet.kidsWithCandies(candies1, 1));
        System.out.println(leet.kidsWithCandies(candies2, 10));
    }
}
