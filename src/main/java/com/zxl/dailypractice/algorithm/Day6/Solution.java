package com.zxl.dailypractice.algorithm.Day6;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
public class Solution {
    //无重复字符的最长子串    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/jian-dan-yi-dong-javac-pythonjshua-dong-bff20/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1){
            return n;
        }
        int maxLen = 1;

        int left = 0,right = 0;
        int[] window = new int[128];
        while (right < n){
            char rightChar = s.charAt(right);
            int rightCharIndex = window[rightChar];
            left = Math.max(left,rightCharIndex);
            maxLen = Math.max(maxLen,right-left+1);
            window[rightChar] = right + 1;
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
