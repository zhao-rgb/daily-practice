package com.zxl.dailypractice.card.may.may25;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/25
 * @Version 1.0
 **/
//环绕字符串中唯一的子字符串   https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k =0;
        for (int i = 0; i < p.length(); i++) {
            if (i>0&&(p.charAt(i)-p.charAt(i-1)+26)%26 == 1){
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i)-'a'] = Math.max(dp[p.charAt(i) - 'a'],k);
        }
        return Arrays.stream(dp).sum();
    }
}
