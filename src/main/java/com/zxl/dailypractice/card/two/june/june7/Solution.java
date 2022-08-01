package com.zxl.dailypractice.card.two.june.june7;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/7
 * @Version 1.0
 **/
//爱吃香蕉的珂珂爱吃香蕉的珂珂         https://leetcode.cn/problems/koko-eating-bananas/
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
