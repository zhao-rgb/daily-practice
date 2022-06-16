package com.zxl.dailypractice.card.june.june17;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/17
 * @Version 1.0
 **/
//复写零       https://leetcode.cn/problems/duplicate-zeros/
public class Solution {
    public void duplicateZeros(int[] A) {
        int n = A.length, cnt0 = 0;
        // 先统计零的总数
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0) {
                ++cnt0;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            // 碰到零就减去，剩余的就是左边零的个数
            if (A[i] == 0) {
                --cnt0;
            }
            // A[i] 向右移动 cnt0 位
            if (i + cnt0 < n) {
                A[i + cnt0] = A[i];
                // 如果 A[i] 是零，移动完之后，后面还要补个零
                if (A[i] == 0 && i + cnt0 + 1 < n) {
                    A[i + cnt0 + 1] = 0;
                }
            }
        }
    }
}
