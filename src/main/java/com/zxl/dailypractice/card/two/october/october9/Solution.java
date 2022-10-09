package com.zxl.dailypractice.card.two.october.october9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhaoxl
 * @date: 2022/10/9
 * @desc:
 **/
public class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        for (char c:s.toCharArray()) {
            if (c == '('){
                d.addLast(0);
            }else {
                int cur = d.pollLast();
                d.addLast(d.pollLast() + Math.max(cur*2 ,1));
            }
        }
        return d.peekLast();
    }

}
