package com.zxl.dailypractice.card.two.june.june6;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/6
 * @Version 1.0
 **/
//我的日程安排表 III     https://leetcode.cn/problems/my-calendar-iii/
public class Solution {
    private TreeMap<Integer, Integer> cnt;

    public Solution() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}
