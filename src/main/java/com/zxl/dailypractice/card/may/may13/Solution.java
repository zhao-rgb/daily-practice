package com.zxl.dailypractice.card.may.may13;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/13
 * @Version 1.0
 **/
//一次编辑    https://leetcode.cn/problems/one-away-lcci/
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(),m = second.length();
        if (Math.abs(n-m) > 1){
            return false;
        }
        if (n > m) {
            return oneEditAway(second,first);
        }
        int i = 0,j = 0,cnt = 0;
        while (i < n && j < m && cnt <= 1){
            char c1 = first.charAt(i),c2 = second.charAt(j);
            if (c1 == c2){
                i++;
                j++;
            } else {
                if (n == m){
                    i++;
                    j++;
                    cnt++;
                } else {
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "pale";
        String b = "pal";
        boolean b1 = solution.oneEditAway(a, b);
        System.out.println(b1);
    }
}
