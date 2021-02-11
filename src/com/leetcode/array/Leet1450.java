package com.leetcode.array;

public class Leet1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;

        for(int i = 0; i < startTime.length; i++){
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] startTime = {1,2,3}, endTime = {3,2,7}; int queryTime = 4;
        int[] startTime1 = {4}, endTime1 = {4};int queryTime1 = 4;
        int[] startTime2 = {4}, endTime2 = {4}; int queryTime2 = 5;
        int[] startTime3 = {1,1,1,1}, endTime3 = {1,3,2,4}; int queryTime3 = 7;

        Leet1450 leet = new Leet1450();
        System.out.println(leet.busyStudent(startTime, endTime, queryTime));
        System.out.println(leet.busyStudent(startTime1, endTime1, queryTime1));
        System.out.println(leet.busyStudent(startTime2, endTime2, queryTime2));
        System.out.println(leet.busyStudent(startTime3, endTime3, queryTime3));
    }
}
