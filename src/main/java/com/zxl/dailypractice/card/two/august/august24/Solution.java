package com.zxl.dailypractice.card.two.august.august24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/8/23
 * @desc:
 **/
//通过翻转子数组使两个数组相等         https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> counts1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> counts2 = new HashMap<Integer, Integer>();
        for (int num : target) {
            counts1.put(num, counts1.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            counts2.put(num, counts2.getOrDefault(num, 0) + 1);
        }
        if (counts1.size() != counts2.size()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : counts1.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (!counts2.containsKey(key) || counts2.get(key) != value) {
                return false;
            }
        }
        return true;
    }
}
