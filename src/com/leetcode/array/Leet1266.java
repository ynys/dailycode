package com.leetcode.array;

public class Leet1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] cur = points[i];
            int[] prev = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;
    }
}
