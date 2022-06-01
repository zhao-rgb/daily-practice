package com.zxl.dailypractice.card.june.june1;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/1
 * @Version 1.0
 **/
//火柴拼正方形    https://leetcode.cn/problems/matchsticks-to-square/    没懂
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,1,2,2,2};
        boolean makesquare = solution.makesquare(a);
        System.out.println(makesquare);
    }
}
