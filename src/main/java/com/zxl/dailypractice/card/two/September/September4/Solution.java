package com.zxl.dailypractice.card.two.September.September4;

/**
 * @author: zhaoxl
 * @date: 2022/9/4
 * @desc:
 **/
//二进制矩阵中的特殊位置        https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
public class Solution {
    public int numSpecial(int[][] mat) {
        int[] r = new int[mat.length];
        int[] c = new int[mat[0].length];
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                r[i] += mat[i][j];
                c[j] += mat[i][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
