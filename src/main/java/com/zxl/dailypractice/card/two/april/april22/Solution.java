package com.zxl.dailypractice.card.two.april.april22;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/22
 * @Version 1.0
 **/
//旋转函数           https://leetcode-cn.com/problems/rotate-function/
public class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0,n = nums.length,numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        // F[i] = F[i-1] + sum - n * nums[n - i]
        for (int i = n-1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res,f);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {4,3,2,6};
        int i = solution.maxRotateFunction(a);
        System.out.println(i);
    }
}
