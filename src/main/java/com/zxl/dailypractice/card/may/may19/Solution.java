package com.zxl.dailypractice.card.may.may19;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/19
 * @Version 1.0
 **/
//最少移动次数使数组元素相等 II          https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2,3,4,5,6,7};
        int i = solution.minMoves2(a);
        System.out.println(i);
    }
}
