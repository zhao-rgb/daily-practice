package com.zxl.dailypractice.card.two.august.august16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/8/16
 * @desc:
 **/
//设计有序流   https://leetcode.cn/problems/design-an-ordered-stream/
public class Solution {
    private String[] stream;
    private int ptr;

    public Solution(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> res = new ArrayList<String>();
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ++ptr;
        }
        return res;
    }
}
