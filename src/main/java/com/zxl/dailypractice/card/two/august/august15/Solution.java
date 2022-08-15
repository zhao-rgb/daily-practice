package com.zxl.dailypractice.card.two.august.august15;

/**
 * @author: zhaoxl
 * @date: 2022/8/15
 * @desc:
 **/
//分割字符串的最大得分      https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
public class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int score = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    score++;
                }
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    score++;
                }
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }
}
