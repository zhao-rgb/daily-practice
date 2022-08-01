package com.zxl.dailypractice.card.two.january.january5;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/1/5
 * @Version 1.0
 **/
//替换所有的问号       https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
public class Solution {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?'){
                for (char ch = 'a'; ch<='c';ch++) {
                    if ((i>0&&arr[i-1]==ch) || (i<n-1&&arr[i+1]==ch)){
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ubv?w";
        String s1 = solution.modifyString(s);
        System.out.println(s1);
    }
}
