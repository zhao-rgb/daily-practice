package com.zxl.dailypractice.card.two.april.april30;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/30
 * @Version 1.0
 **/
//最小差值 I        https://leetcode-cn.com/problems/smallest-range-i/
public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int MaxNum = Arrays.stream(nums).max().getAsInt();
        return MaxNum - minNum <= 2*k ? 0 : MaxNum - minNum -2*k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {0,10};
        int i = solution.smallestRangeI(a, 2);
        System.out.println(i);
    }
}
