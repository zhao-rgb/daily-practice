package com.zxl.dailypractice.card.two.may.may22;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/22
 * @Version 1.0
 **/
//我能赢吗   https://leetcode.cn/problems/can-i-win/
public class Solution {
    int n, t;
    int[][] f = new int[1 << 20][2];
    // 1 true / -1 false
    int dfs(int state, int tot, int k) {
        if (state == ((1 << n) - 1) && tot < t) {
            return -1;
        }
        if (f[state][k % 2] != 0) {
            return f[state][k % 2];
        }
        int hope = k % 2 == 0 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (tot + i + 1 >= t) {
                return f[state][k % 2] = hope;
            }
            if (dfs(state | (1 << i), tot + i + 1, k + 1) == hope) {
                return f[state][k % 2] = hope;
            }
        }
        return f[state][k % 2] = -hope;
    }
    public boolean canIWin(int _n, int _t) {
        n = _n; t = _t;
        if (t == 0) {
            return true;
        }
        return dfs(0, 0, 0) == 1;
    }
}
