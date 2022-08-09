package com.zxl.dailypractice.card.two.august.august9;

/**
 * @author: zhaoxl
 * @date: 2022/8/9
 * @desc:
 **/
//逐步求和得到正数的最小值        https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
public class Solution {
    public int minStartValue(int[] nums) {
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSumMin, accSum);
        }
        return -accSumMin + 1;
    }
}
