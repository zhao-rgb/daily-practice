package com.zxl.dailypractice.card.two.october.october21;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhaoxl
 * @date: 2022/10/21
 * @desc:
 **/
//股票价格跨度     https://leetcode.cn/problems/online-stock-span/
public class Solution {
    Deque<int[]> stack;
    int idx;

    public Solution(){
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1,Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price){
        idx++;
        while (price >= stack.peek()[1]){
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx,price});
        return ret;
    }

}
