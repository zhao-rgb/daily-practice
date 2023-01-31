package com.zxl.dailypractice.card.three.january.january31;

/**
 * @author: zhaoxl
 * @date: 2023/1/31
 * @desc:
 **/
//判断矩阵是否是一个 X 矩阵           https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || (i + j) == (n - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
