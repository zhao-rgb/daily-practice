package com.zxl.dailypractice.card.june.june5;

import java.util.Random;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/6/5
 * @Version 1.0
 **/
//在圆内随机生成点     https://leetcode.cn/problems/generate-random-point-in-a-circle/
public class Solution {
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }
}
