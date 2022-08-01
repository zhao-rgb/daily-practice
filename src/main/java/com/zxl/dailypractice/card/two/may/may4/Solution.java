package com.zxl.dailypractice.card.two.may.may4;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/4
 * @Version 1.0
 **/
//找出游戏的获胜者      https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
public class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }
}
