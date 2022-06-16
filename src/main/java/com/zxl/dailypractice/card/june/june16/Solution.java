package com.zxl.dailypractice.card.june.june16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/16
 * @Version 1.0
 **/
//数组中的 k-diff 数对    https://leetcode.cn/problems/k-diff-pairs-in-an-array/
public class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }
}
