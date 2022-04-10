package com.zxl.dailypractice.card.april.april10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/10
 * @Version 1.0
 **/
//唯一摩尔斯密码词        https://leetcode-cn.com/problems/unique-morse-code-words/
public class Solution {
    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> seen = new HashSet<>();
        for (String word : words){
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                code.append(MORSE[c-'a']);
            }
            seen.add(code.toString());
        }
        return seen.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a = {"gin", "zen", "gig", "msg"};
        int i = solution.uniqueMorseRepresentations(a);
        System.out.println(i);
    }
}
