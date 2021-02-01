package com.leetcode.array;

public class Leet1486 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i==0){
                res = start;
            }else {
                res ^= (start + 2 * i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n1= 5, start1 = 0;
        int n2= 4, start2 = 3;
        int n3= 1, start3 = 7;
        int n4= 10, start4 = 5;

        Leet1486 leet = new Leet1486();
        System.out.println(leet.xorOperation(n1, start1));
        System.out.println(leet.xorOperation(n2, start2));
        System.out.println(leet.xorOperation(n3, start3));
        System.out.println(leet.xorOperation(n4, start4));
    }
}
