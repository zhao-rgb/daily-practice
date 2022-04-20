package com.zxl.dailypractice.card.april.april20;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/20
 * @Version 1.0
 **/
//文件的最长绝对路径     https://leetcode-cn.com/problems/longest-absolute-file-path/
public class Solution {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过换行符 */
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int i = solution.lengthLongestPath(input);
        System.out.println(i);
    }
}
