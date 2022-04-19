package com.zxl.dailypractice.card.april.april19;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/19
 * @Version 1.0
 **/
//字符的最短距离       https://leetcode-cn.com/problems/shortest-distance-to-a-character/
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans,n+1);
        for (int i = 0,j=-1; i < n; i++) {
            if (s.charAt(i) == c){
                j = i;
            }
            if (j != -1){
                ans[i] = i-j;
            }
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                ans[i] = Math.min(ans[i], j - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "aaab";
        char b = 'b';
        int[] ints = solution.shortestToChar(a, b);
        System.out.println(Arrays.toString(ints));
    }
}
