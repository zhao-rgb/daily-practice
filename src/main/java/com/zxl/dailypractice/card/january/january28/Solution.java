package com.zxl.dailypractice.card.january.january28;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/1/27
 * @Version 1.0
 **/
//游戏中弱角色的数量   https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] n = {{1,5},{10,4},{4,3}};
        int i = solution.numberOfWeakCharacters(n);
        System.out.println(i);
    }
}
