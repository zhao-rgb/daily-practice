package com.zxl.dailypractice.algorithm2.Day1;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//数据结构  学习计划    https://leetcode-cn.com/study-plan/data-structures/?progress=m8rfqe7
public class Solution {
    // 存在重复元素      https://leetcode-cn.com/problems/contains-duplicate/
    //方法一
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //最大子数组和   https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
    //方法一
    public int maxSubArray(int[] nums) {
        int pre = 0,maxAns = nums[0];
        for (int x : nums){
            pre = Math.max(pre+x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }

    //方法二
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int numsSize = nums.length;
        int sum = 0;
        for (int i = 0; i < numsSize; i++) {
            sum+=nums[i];
            result = Math.max(result,sum);
            //如果sum<0,重新开始找子序串
            if (sum<0){
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        boolean b = solution.containsDuplicate(nums);
        System.out.println(b);
        //方法二
        System.out.println(Arrays.stream(nums).distinct().count()<nums.length);

        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray1(nums1);
        System.out.println(i);

    }
}
