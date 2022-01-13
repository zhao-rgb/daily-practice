package com.zxl.dailypractice.card.January.january13;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/1/13
 * @Version 1.0
 **/
//至少是其他数字两倍的最大数   https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
public class Solution {
    public int dominantIndex(int[] nums) {
        int m1 = -1,m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1){
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if (nums[i] > m2){
                m2 = nums[i];
            }
        }
        return m1 >= m2*2 ? index : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,6,1,0};
        int i = solution.dominantIndex(nums);
        System.out.println(i);
    }
}
