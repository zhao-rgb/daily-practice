package com.zxl.dailypractice.card.two.august.august30;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/8/30
 * @desc:
 **/
//数组中两元素的最大乘积    https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
public class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }
}
