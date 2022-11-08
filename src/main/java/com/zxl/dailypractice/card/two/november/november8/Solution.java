package com.zxl.dailypractice.card.two.november.november8;

/**
 * @author: zhaoxl
 * @date: 2022/11/3
 * @desc:
 **/
//统计一致字符串的数目       https://leetcode.cn/problems/count-the-number-of-consistent-strings/
public class Solution {
    public static void main(String[] args) {
        System.out.println(System.getProperty("usr.home", "/slview"));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
