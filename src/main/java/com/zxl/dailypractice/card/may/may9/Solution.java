package com.zxl.dailypractice.card.may.may9;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/9
 * @Version 1.0
 **/
//增减字符串匹配      https://leetcode.cn/problems/di-string-match/
public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length(),lo = 0,hi = n;
        int[] perm = new int[n+1];
        for (int i = 0; i < n; i++) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo;
        return perm;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] iddis = solution.diStringMatch("IDID");
        System.out.println(Arrays.toString(iddis));
    }
}
