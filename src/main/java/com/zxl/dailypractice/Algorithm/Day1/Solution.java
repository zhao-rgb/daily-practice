package com.zxl.dailypractice.Algorithm.Day1;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/18
 * @Version 1.0
 **/
//算法  学习计划      https://leetcode-cn.com/study-plan/algorithms/?progress=ahdp8xe
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7, 10};
        int target = 11;
        Solution solution = new Solution();
        int i = solution.search(nums, target);
        System.out.println(i);
        int j = solution.searchInsert(nums, target);
        System.out.println(j);
    }

    //二分查找  https://leetcode-cn.com/problems/binary-search/
    public  int search(int[] nums, int target){
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    //搜索插入位置   https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
