package com.zxl.dailypractice.algorithm2.Day2;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
public class Solution {
    //合并两个有序数组   https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
    public int[] merge(int[] nums1,int m,int[] nums2,int n){
        for (int i = 0; i < n; i++) {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] merge = solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(merge));
    }
}
