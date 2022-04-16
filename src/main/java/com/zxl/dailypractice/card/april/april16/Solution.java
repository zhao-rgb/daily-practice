package com.zxl.dailypractice.card.april.april16;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/16
 * @Version 1.0
 **/
//最大回文数乘积   https://leetcode-cn.com/problems/largest-palindrome-product/
public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.largestPalindrome(2);
        System.out.println(i);
    }
}
