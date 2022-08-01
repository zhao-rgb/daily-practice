package com.zxl.dailypractice.card.two.july.july16;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zhaoxl
 * @date: 2022/7/15
 * @desc:
 **/
//剑指 Offer II 041. 滑动窗口的平均值       https://leetcode.cn/problems/qIsx9U/
public class Solution {
    Queue<Integer> queue;
    int size;
    double sum;

    public Solution(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
