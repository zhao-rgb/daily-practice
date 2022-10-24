package com.zxl.dailypractice.card.two.october.october24;

/**
 * @author: zhaoxl
 * @date: 2022/10/24
 * @desc:
 **/
//分割数组    https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        int maxLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return n - 1;
    }
}
