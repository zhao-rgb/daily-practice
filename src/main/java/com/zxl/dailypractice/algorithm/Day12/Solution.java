package com.zxl.dailypractice.algorithm.Day12;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
public class Solution {
    //爬楼梯     https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
    public int climbStairs(int n) {
        int p = 0,q = 0,r = 1;
        for (int i = 1; i <= n ; i++) {
            p = q;
            q = r;
            r= p + q;
        }
        return r;
    }

    //打家劫舍    https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int first = nums[0],second = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i],second);
            first = temp;
        }
        return second;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.climbStairs(3);
        System.out.println(i);

        int[] num = {2,7,9,3,1};
        int rob = solution.rob(num);
        System.out.println(rob);
    }
}
