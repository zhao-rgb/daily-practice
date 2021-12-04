package com.zxl.dailypractice.Algorithm.Day3;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/21
 * @Version 1.0
 **/
public class Solution {

    //移动零       https://leetcode-cn.com/problems/move-zeroes/
    public void moveZeroes(int[] nums) {
        if(nums == null){
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i =j;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    //两数之和 II - 输入有序数组       https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leet-2/
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while(left<=right){
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left+1,right+1};
            } else if(numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
