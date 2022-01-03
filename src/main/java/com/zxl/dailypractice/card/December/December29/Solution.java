package com.zxl.dailypractice.card.December.December29;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/29
 * @Version 1.0
 **/
//统计特殊四元组     https://leetcode-cn.com/problems/count-special-quadruplets/
public class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (nums[i]+nums[j]+nums[k]==nums[l]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,3,5};
        int i = solution.countQuadruplets(nums);
        System.out.println(i);
    }
}
