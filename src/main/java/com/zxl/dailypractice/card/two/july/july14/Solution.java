package com.zxl.dailypractice.card.two.july.july14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/7/14
 * @Version 1.0
 **/
//前缀和后缀搜索     https://leetcode.cn/problems/prefix-and-suffix-search/
public class Solution {
    Map<String, Integer> dictionary;

    public Solution(String[] words) {
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                    dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return dictionary.getOrDefault(pref + "#" + suff, -1);
    }
}
