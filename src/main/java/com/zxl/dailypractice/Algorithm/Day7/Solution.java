package com.zxl.dailypractice.Algorithm.Day7;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/23
 * @Version 1.0
 **/
public class Solution {
    // 图像渲染   https://leetcode-cn.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    void helper(int[][] image,int sr,int sc,int newColor,int oldColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != oldColor || newColor == oldColor){
            return;
        }
        image[sr][sc] = newColor;
        helper(image,sr-1,sc,newColor,oldColor);
        helper(image, sr + 1, sc, newColor, oldColor);
        helper(image, sr, sc - 1, newColor, oldColor);
        helper(image, sr, sc + 1, newColor, oldColor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //图像渲染测试
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] ints = solution.floodFill(image, 1, 1, 2);
        for(int[] x : ints){
            for(int e: x){
                System.out.print(e + " ");
            }
            System.out.println();
        }

        //岛屿的最大面积测试
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int i = solution.maxAreaOfIsland(grid);
        System.out.println(i);
    }
    //岛屿的最大面积    https://leetcode-cn.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans =Math.max(ans,IslandDFS(grid,i,j));
            }
        }
        return ans;
    }

    int IslandDFS(int[][] grid,int i,int j){
        if((i<grid.length)&&(i>=0) && (j<grid[0].length) && (j>=0)){
            if (grid[i][j] == 0){
                return 0;
            }
            else {
                grid[i][j] = 0;
                return 1 + IslandDFS(grid,i-1,j)+
                        IslandDFS(grid,i+1,j)+IslandDFS(grid,i,j-1)
                        +IslandDFS(grid,i,j+1);
            }
        }
        else {
            return 0;
        }
    }
}
