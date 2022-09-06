package com.zxl.dailypractice.card.two.September.September6;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/9/6
 * @desc:
 **/
//统计子串中的唯一字符           https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class Solution {
    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        int[] cnts = new int[26];
        Arrays.fill(cnts, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = cnts[u];
            cnts[u] = i;
        }
        Arrays.fill(cnts, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = cnts[u];
            cnts[u] = i;
        }
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }
}
