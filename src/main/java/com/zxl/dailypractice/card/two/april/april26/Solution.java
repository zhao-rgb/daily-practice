package com.zxl.dailypractice.card.two.april.april26;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/26
 * @Version 1.0
 **/
//三维形体投影面积   https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
public class Solution {
    public int projectionArea(int[][] grid) {
        int ans1 = 0,ans2 = 0,ans3 = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int a = 0,b = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0){
                    ans1++;
                }
                a = Math.max(a,grid[i][j]);
                b = Math.max(b,grid[j][i]);
            }
            ans2 += a;
            ans3 += b;
        }
        return ans1+ans2+ans3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,2},{3,4}};
        int i = solution.projectionArea(a);
        System.out.println(i);
    }
}
