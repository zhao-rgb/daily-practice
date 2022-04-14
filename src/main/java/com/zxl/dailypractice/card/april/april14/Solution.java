package com.zxl.dailypractice.card.april.april14;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/14
 * @Version 1.0
 **/
//最富有客户的资产总量      https://leetcode-cn.com/problems/richest-customer-wealth/
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] a : accounts){
            max = Math.max(max, Arrays.stream(a).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] b = {{1,2,3},{2,3,4}};
        int i = solution.maximumWealth(b);
        System.out.println(i);
    }
}
