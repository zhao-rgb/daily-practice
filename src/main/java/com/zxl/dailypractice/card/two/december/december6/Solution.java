package com.zxl.dailypractice.card.two.december.december6;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhaoxl
 * @date: 2022/12/6
 * @desc:
 **/
//字符串中不同整数的数目        https://leetcode.cn/problems/number-of-different-integers-in-a-string/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.numDifferentIntegers("a123bc34d8ef34");
        System.out.println(a);
    }
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length(),p1 = 0,p2;
        while (true){
            while (p1 < n && !Character.isDigit(word.charAt(p1))){
                p1++;
            }
            if (p1 == n){
                break;
            }
            p2 = p1;
            while (p2 < n && !Character.isDigit(word.charAt(p2))){
                p2++;
            }
            while (p2 - p1 > 1 && word.charAt(p1) == '0'){
                p1++;
            }
            set.add(word.substring(p1,p2));
            p1 = p2;
        }
        return set.size();
    }
}
