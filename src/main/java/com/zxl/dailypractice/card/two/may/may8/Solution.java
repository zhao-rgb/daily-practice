package com.zxl.dailypractice.card.two.may.may8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/8
 * @Version 1.0
 **/
//数组中重复的数据       https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = solution.findDuplicates(a);
        System.out.println(duplicates);
    }
}
