package com.zxl.dailypractice.card.two.august.august8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/8/8
 * @desc:
 **/
//数组中的字符串匹配    https://leetcode.cn/problems/string-matching-in-an-array/
public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a = {"mass","as","hero","superhero"};
        List<String> list = solution.stringMatching(a);
        System.out.println(list);
    }
}
