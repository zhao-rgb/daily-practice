package com.zxl.dailypractice.card.two.october.october8;

/**
 * @author: zhaoxl
 * @date: 2022/10/8
 * @desc:
 **/
//最大升序子数组和           https://leetcode.cn/problems/maximum-ascending-subarray-sum/
public class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int cursum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                cursum += nums[l++];
            }
            res = Math.max(res, cursum);
        }
        return res;
    }
}
