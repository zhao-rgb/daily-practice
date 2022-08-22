package com.zxl.dailypractice.card.two.august.august22;

/**
 * @author: zhaoxl
 * @date: 2022/8/22
 * @desc:
 **/
//检查单词是否为句中其他单词的前缀    https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
public class Solution {
    public int isPrefixOfWord(String s, String t) {
        String[] ss = s.split(" ");
        int n = ss.length, m = t.length();
        for (int i = 0; i < n; i++) {
            if (ss[i].length() < m) {
                continue;
            }
            boolean ok = true;
            for (int j = 0; j < m && ok; j++) {
                if (ss[i].charAt(j) != t.charAt(j)) ok = false;
            }
            if (ok) {
                return i + 1;
            }
        }
        return -1;
    }
}
