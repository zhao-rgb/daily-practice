package com.zxl.dailypractice.card.December.December19;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/20
 * @Version 1.0
 **/
//找到小镇的法官      https://leetcode-cn.com/problems/find-the-town-judge/
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];
        for (int[] edge : trust){
            int x = edge[0];
            int y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n-1 && outDegrees[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] trust = {{1,3},{2,3}};
        int judge = solution.findJudge(3, trust);
        System.out.println(judge);
    }
}
