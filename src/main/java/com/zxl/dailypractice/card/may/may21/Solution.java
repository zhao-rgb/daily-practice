package com.zxl.dailypractice.card.may.may21;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/21
 * @Version 1.0
 **/
//在长度 2N 的数组中找出重复 N 次的元素      https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> found = new HashSet<Integer>();
        for (int num : nums) {
            if (!found.add(num)) {
                return num;
            }
        }
        // 不可能的情况
        return -1;
    }
}
