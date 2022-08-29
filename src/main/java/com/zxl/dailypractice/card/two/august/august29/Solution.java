package com.zxl.dailypractice.card.two.august.august29;

/**
 * @author: zhaoxl
 * @date: 2022/8/29
 * @desc:
 **/
//重新排列数组      https://leetcode.cn/problems/shuffle-the-array/
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+n];
        }
        return ans;
    }
}
