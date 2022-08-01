package com.zxl.dailypractice.card.two.july.july29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/7/29
 * @desc:
 **/
//有效的正方形  https://leetcode.cn/problems/valid-square/
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] points = new int[][]{p1, p2, p3, p4};
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int d = distance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }
        if (map.size() != 2) {
            return false;
        }
        int x = Integer.MIN_VALUE, y = 0;
        for (int key: map.keySet()) {
            if (x != Integer.MIN_VALUE) {
                y = key;
            } else {
                x = key;
            }
        }
        if (x > y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        return y == 2 * x && map.get(x) == 4 && map.get(y) == 2;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
