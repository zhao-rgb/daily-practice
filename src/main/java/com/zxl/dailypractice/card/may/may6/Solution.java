package com.zxl.dailypractice.card.may.may6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/6
 * @Version 1.0
 **/
//最近的请求次数      https://leetcode-cn.com/problems/number-of-recent-calls/
public class Solution {
    Queue<Integer> queue;
    Stack<Integer> stack;

    public Solution() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ping = solution.ping(1);
    }

}
