package com.zxl.dailypractice.card.three.nine.nine5;

/**
 * @author: zhaoxl
 * @date: 2023/9/5
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String roadTakeUpSpaceRate = "9.2";
        //封顶1.2
        float inputFloat = Float.parseFloat(roadTakeUpSpaceRate);

        // 检查浮点数是否大于1.2
        if (inputFloat > 1.2) {
            inputFloat = 1.2f;
        }
        System.out.println(String.valueOf(inputFloat));
    }
}
