package com.zxl.dailypractice.card.july.july13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/7/13
 * @Version 1.0
 **/
//行星碰撞  https://leetcode.cn/problems/asteroid-collision/
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int aster : asteroids){
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() >0){
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster){
                    stack.pop();
                }
            }
            if (alive){
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
