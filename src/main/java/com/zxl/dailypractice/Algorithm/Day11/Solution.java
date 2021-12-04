package com.zxl.dailypractice.Algorithm.Day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
public class Solution {
    //全排列    https://leetcode-cn.com/problems/permutations/solution/pei-yang-chou-xiang-neng-li-de-yi-dao-ti-1731/
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,path,res,used);
        return res;
    }

    private void dfs(int[] nums,
                     List<Integer> path,
                     List<List<Integer>> res,
                     boolean[] used) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
           //剪枝,判断重复使用的数字
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,path,res,used);
            //回溯的过程中，将当前的节点从path中删除
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
