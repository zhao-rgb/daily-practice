package com.zxl.dailypractice.card.two.november.november3;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/11/3
 * @desc:
 **/
//最大重复子字符串    https://leetcode.cn/problems/maximum-repeating-substring/
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
