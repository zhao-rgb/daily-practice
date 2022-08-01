package com.zxl.dailypractice.card.two.may.may5;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/5
 * @Version 1.0
 **/
//乘积小于 K 的子数组     https://leetcode-cn.com/problems/subarray-product-less-than-k/
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length,ans = 0;
        if (k <= 1){
            return 0;
        }
        for (int i = 0,j=0,cur=1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k){
                cur /= nums[j++];
            }
            ans += i-j+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {10,5,2,6};
        int b = 100;
        int i = solution.numSubarrayProductLessThanK(a, b);
        System.out.println(i);
    }
}
