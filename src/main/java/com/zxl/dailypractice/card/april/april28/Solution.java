package com.zxl.dailypractice.card.april.april28;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/28
 * @Version 1.0
 **/
//按奇偶排序数组   https://leetcode-cn.com/problems/sort-array-by-parity/
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3,1,2,4};
        int[] ints = solution.sortArrayByParity(a);
        System.out.println(Arrays.toString(ints));
    }
}
