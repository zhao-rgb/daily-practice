package com.zxl.dailypractice.card.july.july4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/7/4
 * @Version 1.0
 **/
//最小绝对差   https://leetcode.cn/problems/minimum-absolute-difference/
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length, min = arr[1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            int cur = arr[i + 1] - arr[i];
            if (cur < min) {
                ans.clear();
                min = cur;
            }
            if (cur == min) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]); temp.add(arr[i + 1]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
