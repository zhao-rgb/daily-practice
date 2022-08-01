package com.zxl.dailypractice.card.two.april.april7;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/7
 * @Version 1.0
 **/
// 旋转字符串   https://leetcode-cn.com/problems/rotate-string/
public class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcde";
        String goal = "cdeab";
        boolean b = solution.rotateString(s, goal);
        System.out.println(b);
    }
}
