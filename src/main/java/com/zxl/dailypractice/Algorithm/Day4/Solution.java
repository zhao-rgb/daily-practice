package com.zxl.dailypractice.Algorithm.Day4;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/22
 * @Version 1.0
 **/
public class Solution {
    //反转字符串     https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode-solution/
    public void reverseString(char[] s) {
        int n= s.length;
        for(int left = 0,right=n-1;left<right;left++,right--){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    //反转字符串中的单词 III    https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (String str : strs) {
            buffer.append(new StringBuffer(str).reverse().toString());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        char [] a ={'a','b','c','f'};
        System.out.println(Arrays.toString(a));
        Solution solution = new Solution();
        solution.reverseString(a);
        System.out.println(Arrays.toString(a));

        String b = "hello china";
        String s = solution.reverseWords(b);
        System.out.println(s);

    }
}
