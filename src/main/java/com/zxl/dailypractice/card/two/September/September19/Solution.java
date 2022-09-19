package com.zxl.dailypractice.card.two.September.September19;

import java.util.*;

/**
 * @author: zhaoxl
 * @date: 2022/9/19
 * @desc:
 **/
//按照频率将数组升序排序      https://leetcode.cn/problems/sort-array-by-increasing-frequency/
public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums){
            cnt.put(num,cnt.getOrDefault(num,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        Collections.sort(list,(a,b) ->{
            int cnt1 = cnt.get(a),cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 -  cnt2 : b-a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,2,3};
        int[] ints = solution.frequencySort(nums);
        System.out.println(Arrays.toString(ints));
    }
}
