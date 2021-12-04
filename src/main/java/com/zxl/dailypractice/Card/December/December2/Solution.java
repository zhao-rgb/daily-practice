package com.zxl.dailypractice.Card.December.December2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//相对名次      https://leetcode-cn.com/problems/relative-ranks/
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        Arrays.sort(score);
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int s = map.get(score[i]);
            if(i==score.length-1){
                ans[s] = "Gold Medal";
            } else if (i==score.length-2){
                ans[s] = "Silver Medal";
            } else if (i==score.length-3){
                ans[s] = "Bronze Medal";
            } else {
                ans[s] = String.valueOf(score.length-i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] score = {5,4,3,2,1};
        String[] relativeRanks = solution.findRelativeRanks(score);
        System.out.println(Arrays.toString(relativeRanks));
    }
}
