package com.zxl.dailypractice.card.two.april.april3;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/3
 * @Version 1.0
 **/
// 寻找比目标字母大的最小字母      https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char nextGreater = letters[0];
        for (char letter : letters) {
            if (letter > target) {
                nextGreater = letter;
                break;
            }
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] a ={'c','f','j'};
        char b = 'a';
        char c = solution.nextGreatestLetter(a, b);
        System.out.println(c);
    }
}
