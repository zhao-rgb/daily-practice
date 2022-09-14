package com.zxl.dailypractice.card.two.September.September14;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/9/14
 * @desc:
 **/
//删除某些元素后的数组均值    https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int removeCount = (int) (n*0.05);
        int sum = 0;
        for (int i = removeCount; i < n-removeCount; i++) {
            sum += arr[i];
        }
        return sum / (n*0.9);
    }
}
