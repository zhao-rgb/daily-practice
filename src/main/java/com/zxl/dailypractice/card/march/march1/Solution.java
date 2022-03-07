package com.zxl.dailypractice.card.march.march1;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/3/7
 * @Version 1.0
 **/
//七进制数     https://leetcode-cn.com/problems/base-7/
public class Solution {
    public String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs((num));
        StringBuffer digits = new StringBuffer();
        while (num > 0){
            digits.append(num%7);
            num /= 7;
        }
        if (negative){
            digits.append("-");
        }
        return digits.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.convertToBase7(100);
        System.out.println(s);

    }
}
