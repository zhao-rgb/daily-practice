package com.zxl.dailypractice.card.two.april.april12;

import java.util.Arrays;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/12
 * @Version 1.0
 **/
//写字符串需要的行数        https://leetcode-cn.com/problems/number-of-lines-to-write-string/
public class Solution {
    public static final int MAX_WIDTH = 100;

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > MAX_WIDTH){
                lines++;
                width = need;
            }
        }
        return new int[]{lines,width};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] ints = solution.numberOfLines(widths, s);
        System.out.println(Arrays.toString(ints));
    }
}
