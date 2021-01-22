package com.leetcode.tree;

public class Leet733 {
    //Time & Space: O(n), n is the pixels number
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image; // to avoid infinite case/overflow
        //1, 1, 1
        //1,1,1
        //1,1,1
        //starting point 1,1; newColor = 1

        fill(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor){
        //check boundaries
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
                || image[sr][sc] != color) //does not have the same color as the starting color
            return;

        image[sr][sc] = newColor;//fill with new color
        fill(image, sr + 1, sc, color, newColor);//up
        fill(image, sr - 1, sc, color, newColor);//down
        fill(image, sr, sc - 1, color, newColor);//left
        fill(image, sr, sc + 1, color, newColor);//right
    }
}
