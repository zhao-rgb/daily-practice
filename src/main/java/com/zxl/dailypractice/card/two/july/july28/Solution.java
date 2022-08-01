package com.zxl.dailypractice.card.two.july.july28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/7/28
 * @desc:
 **/
//数组序号转换        https://leetcode.cn/problems/rank-transform-of-an-array/
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr,0,sortedArr,0,arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> ranks = new HashMap<>();
        int[] ans = new int[arr.length];
        for (int a : sortedArr) {
            if (!ranks.containsKey(a)) {
                ranks.put(a, ranks.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
