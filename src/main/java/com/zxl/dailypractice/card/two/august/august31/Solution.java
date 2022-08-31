package com.zxl.dailypractice.card.two.august.august31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhaoxl
 * @date: 2022/8/31
 * @desc:
 **/
//验证栈序列   https://leetcode.cn/problems/validate-stack-sequences/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0,j = 0; i < pushed.length; i++) {
            d.addLast(pushed[i]);
            while (!d.isEmpty() && d.peekLast() == popped[j] && ++j >= 0){
                d.pollLast();
            }
        }
        return d.isEmpty();
    }
}
