package com.leetcode.array;

public class Leet1295 {
    //S1: my way
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int num: nums){
            if(String.valueOf(num).length()%2 == 0){
                count++;
            }
        }

        return count;
    }

    //S2: math
    public int findNumbers2(int[] nums) {
        int count = 0;
        for(int num: nums){
            if((int)(Math.log10(num) + 1) % 2 == 0){
                count++;
            }
        }

        return count;
    }

    //S3: Divide and conquer
    public int findNumbers3(int[] nums) {
        int count = 0;

        for(int number: nums){
            //11->99
            //1000 -> 9999
            if (number < 100 && number >= 10 || number >= 1000 && number < 10000 || number == 100000) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int[] nums2 = {555,901,482,1771};
        Leet1295 leet = new Leet1295();
        System.out.println(leet.findNumbers(nums));
        System.out.println(leet.findNumbers2(nums));
        System.out.println(leet.findNumbers3(nums));
        System.out.println(leet.findNumbers(nums2));
        System.out.println(leet.findNumbers2(nums2));
        System.out.println(leet.findNumbers3(nums2));

        int x = 0;
        double y = 2.00;
        System.out.println( y % 2 ==0);
    }
}
