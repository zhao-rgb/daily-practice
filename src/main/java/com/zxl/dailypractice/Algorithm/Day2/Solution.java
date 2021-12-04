package com.zxl.dailypractice.Algorithm.Day2;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/18
 * @Version 1.0
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        Solution solution = new Solution();
        int[] rotate = solution.rotate(nums, 2);
        System.out.println(Arrays.toString(rotate));

        int[] ints = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }
    //轮转数组        https://leetcode-cn.com/problems/rotate-array/
    public int[] rotate(int[] nums,int k){
        int n  = nums.length;
        int [] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i+k)%n] = nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
        return newArr;
    }

    //有序数组的平方   https://leetcode-cn.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums){
        int[] ans = new int[nums.length];
        for(int i = 0; i< nums.length;i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
