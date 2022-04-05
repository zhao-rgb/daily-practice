package com.zxl.dailypractice.card.april.april5;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/5
 * @Version 1.0
 **/
// 二进制表示中质数个计算置位  https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
public class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; ++x) {
            if (isPrime(Integer.bitCount(x))) {
                ++ans;
            }
        }
        return ans;
    }
    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countPrimeSetBits(6, 10);
        System.out.println(i);
    }
}
