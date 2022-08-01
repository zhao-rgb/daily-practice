package com.zxl.dailypractice.card.two.june.june3;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/3
 * @Version 1.0
 **/
//连续整数求和   https://leetcode.cn/problems/consecutive-numbers-sum/
public class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        int bound = 2 * n;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }
}
