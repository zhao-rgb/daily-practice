package com.zxl.dailypractice.card.two.april.april25;

import java.util.*;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/25
 * @Version 1.0
 **/
//随机数索引   https://leetcode-cn.com/problems/random-pick-index/
public class Solution {
    Map<Integer, List<Integer>> pos;
    Random random;

    public Solution(int[] nums) {
        pos = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            pos.putIfAbsent(nums[i],new ArrayList<Integer>());
            pos.get(nums[i]).add(i);
        }
        System.out.println(pos);
    }

    public int pick(int target) {
        List<Integer> a = pos.get(target);
        return a.get(random.nextInt(a.size()));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5};
        Solution solution = new Solution(nums);
        int pick = solution.pick(3);
        System.out.println(pick);
    }
}
