package com.zxl.dailypractice.algorithm1.Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//高效制胜 学习计划    https://leetcode-cn.com/study-plan/efficient-winning/?progress=ax9g126
public class Solution {
    //1. 两数之和        https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
    //方法一 暴力枚举
    public int[] twoSum(int[] nums,int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    //方法二 哈希表
    public int[] twoSum1(int[] nums,int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }

    //两数之和 II - 输入有序数组    https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leet-2/
    public int[] twoSum2(int[] numbers,int target){
        int left = 0,right = numbers.length-1;
        while (left<=right){
            if(numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            } else if (numbers[left]+numbers[right]<target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,15};
        int[] ints = solution.twoSum2(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
