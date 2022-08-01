package com.zxl.dailypractice.card.two.july.july25;

/**
 * @author: zhaoxl
 * @date: 2022/7/25
 * @desc:
 **/
//公交站间的距离       https://leetcode.cn/problems/distance-between-bus-stops/
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}
