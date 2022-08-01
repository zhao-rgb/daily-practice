package com.zxl.dailypractice.card.two.july.july11;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/7/11
 * @Version 1.0
 **/
//实现一个魔法字典    https://leetcode.cn/problems/implement-magic-dictionary/
public class Solution {
    private String[] words;

    public Solution() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : words) {
            if (word.length() != searchWord.length()) {
                continue;
            }

            int diff = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    ++diff;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}
