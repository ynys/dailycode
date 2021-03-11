package com.leetcode.array;

public class Leet1351 {
    //S1: take advantage the sorted nature for row and column,
    //since for each row/column, it is non-increasing
    public int countNegatives(int[][] grid) {
        int m = grid.length;//rows
        int n = grid[0].length;//columns
        //starting from bottom-left corner
        int r = m - 1;
        int c = 0;
        int count = 0;

        while(r >=0 && c < n){
            if(grid[r][c] < 0){
                r--;
                count += n - c;// n - c negative numbers in the current row, that means if grid[r][c] < 0, the rest of row is all 0
            }else {
                c++;//go to next column
            }
        }

        return count;
    }
    //S2: binary search?
    //T: O(mlgn)
    //S: O(1)
    public int countNegatives2(int[][] grid)
    {
        int c = 0;
        for (int i = 0, end = grid[i].length - 1; i < grid.length; i++) {
            int start = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            c = c + grid[i].length - start;
            end = start - 1;
        }
        return c;

    }
    //S3: brute force to scan each cell,
    //T: O(mn)
    //S: O(1)
}
