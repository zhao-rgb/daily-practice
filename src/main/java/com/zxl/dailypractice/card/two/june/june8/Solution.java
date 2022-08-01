package com.zxl.dailypractice.card.two.june.june8;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/8
 * @Version 1.0
 **/
//有效的回旋镖    https://leetcode.cn/problems/valid-boomerang/
public class Solution {
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
