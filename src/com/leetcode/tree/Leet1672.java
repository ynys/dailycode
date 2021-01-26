package com.leetcode.tree;

public class Leet1672 {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;

        for (int[] account : accounts) {
            int wealth = 0;
            for (int balance : account) {
                wealth += balance;
            }

            richest = Math.max(wealth, richest);
        }

        return richest;
    }

    public static void main(String[] args) {
        int[][] accounts1 = {{1,2,3},{3,2,1}};
        int[][] accounts2 = {{1,5},{7,3},{3,5}};
        int[][] accounts3 = {{2,8,7},{7,1,3},{1,9,5}};

        Leet1672 leet = new Leet1672();
        System.out.println(leet.maximumWealth(accounts1));
        System.out.println(leet.maximumWealth(accounts2));
        System.out.println(leet.maximumWealth(accounts3));
    }
}
