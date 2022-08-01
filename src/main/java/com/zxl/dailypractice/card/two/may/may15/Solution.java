package com.zxl.dailypractice.card.two.may.may15;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/15
 * @Version 1.0
 **/
//最大三角形面积    https://leetcode.cn/problems/largest-triangle-area/
public class Solution {
    public double largestTriangleArea(int[][] ps) {
        int n = ps.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cur = cross(ps[j][0] - ps[i][0], ps[j][1] - ps[i][1], ps[k][0] - ps[i][0], ps[k][1] - ps[i][1]);
                    ans = Math.max(ans, Math.abs(cur / 2.0));
                }
            }
        }
        return ans;
    }
    int cross(int a, int b, int c, int d) {
        return a * d - c * b;
    }
}
