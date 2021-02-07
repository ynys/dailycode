package com.leetcode.array;

public class Leet1732 {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int attitude = 0;

        for(int g: gain){
            attitude += g;
            highest = Math.max(attitude, highest);
        }

        return highest;
    }

    public static void main(String[] args) {
        Leet1732 leet = new Leet1732();
        int[] gain1 = {-5,1,5,0,-7};
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        System.out.println(leet.largestAltitude(gain1));
        System.out.println(leet.largestAltitude(gain2));
    }
}
