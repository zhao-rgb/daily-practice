package com.zxl.dailypractice.card.two.october.october19;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/10/19
 * @desc:
 **/
//无法吃午餐的学生数量     https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}
