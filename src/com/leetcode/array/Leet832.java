package com.leetcode.array;

import java.util.Arrays;

public class Leet832 {
    //S1: straightforward
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image){
            //flip
            int t;
            for(int i = 0; i < row.length/2; i++){
                t = row[i];
                row[i] = row[row.length - i - 1];
                row[row.length - i - 1] = t;
            }
            //invert
            for(int j = 0; j < row.length; j++){
                row[j] = 1 - row[j];
            }

            System.out.println(Arrays.toString(row));
        }
        return image;
    }

    //S2: ?
    public int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1,1,0},{1,0,1},{0,0,0}
        };
        int[][] image2 = {
                {1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}
        };

        Leet832 leet = new Leet832();

        leet.flipAndInvertImage(image1);
        leet.flipAndInvertImage(image2);
    }
}
