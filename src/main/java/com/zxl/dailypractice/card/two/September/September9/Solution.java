package com.zxl.dailypractice.card.two.September.September9;

/**
 * @author: zhaoxl
 * @date: 2022/9/9
 * @desc:
 **/
//文件夹操作日志搜集器    https://leetcode.cn/problems/crawler-log-folder/
public class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs){
            if ("./".equals(log)){
                continue;
            } else if ("../".equals(log)){
                if (depth > 0){
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }
}
