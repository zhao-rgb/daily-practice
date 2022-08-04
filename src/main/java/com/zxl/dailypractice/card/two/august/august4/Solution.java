package com.zxl.dailypractice.card.two.august.august4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/8/3
 * @desc:
 **/
//非递增顺序的最小子序列      https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }
}
