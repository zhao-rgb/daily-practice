package com.zxl.dailypractice.card.two.august.august1;

/**
 * @author: zhaoxl
 * @date: 2022/8/1
 * @desc:
 **/
//生成每种字符都是奇数个的字符串  https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
public class Solution {
    public String generateTheString(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if (n % 2 == 1){
            return stringBuffer.append("a".repeat(n)).toString();
        }
        return stringBuffer.append("a".repeat(n-1)).append("b").toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.generateTheString(3);
        System.out.println(s);
    }
}
