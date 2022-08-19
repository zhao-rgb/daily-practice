package com.zxl.dailypractice.card.two.august.august19;

/**
 * @author: zhaoxl
 * @date: 2022/8/19
 * @desc:
 **/
//在既定时间做作业的学生人数  https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
public class Soluiton {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}
