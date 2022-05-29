package com.zxl.dailypractice.card.may.may28;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/28
 * @Version 1.0
 **/
//删除最外层的括号    https://leetcode.cn/problems/remove-outermost-parentheses/solution/by-fuxuemingzhu-k7xg/
public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuffer res = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return res.toString();
    }

}
