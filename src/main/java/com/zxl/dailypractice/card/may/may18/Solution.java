package com.zxl.dailypractice.card.may.may18;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/18
 * @Version 1.0
 **/
//乘法表中第k小的数        https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
