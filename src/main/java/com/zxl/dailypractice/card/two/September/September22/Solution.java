package com.zxl.dailypractice.card.two.September.September22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/9/22
 * @desc:
 **/
//能否连接形成数组     https://leetcode.cn/problems/check-array-formation-through-concatenation/
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < n;) {
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int j = index.get(arr[i]), len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }
}
