package com.zxl.dailypractice.card.december.December12;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/12
 * @Version 1.0
 **/
public class Solution {
    //转换成小写字母      https://leetcode-cn.com/problems/to-lower-case/
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        String s = "LOVELY";
        Solution solution = new Solution();
        String s1 = solution.toLowerCase(s);
        System.out.println(s1);
    }
}
