package com.zxl.dailypractice.card.two.april.april11;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/11
 * @Version 1.0
 **/
//统计各位数字都不同的数字个数          https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n-1; i++) {
            cur *= 9-i;
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }
}
