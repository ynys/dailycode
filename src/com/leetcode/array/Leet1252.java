package com.leetcode.array;

public class Leet1252 {
    //better ??
    //l is indices'length
    //time: O(mn + l)
    //s: O(m+n)
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
        for (int[] idx : indices) {
            //^: bitwise XOR, if they are different, then true, otherwise, false
            oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
            }
        }
        return cnt;
    }

    //Time: O(mn + l)
    //S: O(mn)
    public int oddCells2(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];//default is 0 for each cell, no need to initialize
        int count = 0;

        for (int[] index : indices) {
            int targetRow = index[0];
            int targetCol = index[1];

            for (int c = 0; c < m; c++) {
                matrix[targetRow][c]++;
            }

            for (int r = 0; r < n; r++) {
                matrix[r][targetCol]++;
            }
        }

        for(int r = 0; r < n; r++){
            for(int j = 0; j < m; j++){
                if(matrix[r][j]%2 != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leet1252 leet = new Leet1252();
        int n1 = 2, m1 = 3;
        int[][] indices = {{0,1}, {1,1}};

        System.out.println(leet.oddCells(n1,m1,indices));

        int n2 = 2, m2 = 2;
        int[][] indices2 = {{1,1}, {0,0}};
        System.out.println(leet.oddCells(n2,m2,indices2));

    }
}
