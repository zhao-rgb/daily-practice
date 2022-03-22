package com.zxl.dailypractice.card.december.December3;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//K 次取反后最大化的数组和           https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/solution/k-ci-qu-fan-hou-zui-da-hua-de-shu-zu-he-4r5lb/
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //排序，把尽可能的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if(nums[i]<0 && k>0){
                nums[i] = -1*nums[i];
                k--;
            }
            sum+=nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum-(k%2==0?0:2*nums[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,-3,-1,5,-4};
        int i = solution.largestSumAfterKNegations(nums, 2);
        System.out.println(i);
    }

}
