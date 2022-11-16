package com.zxl.dailypractice.card.two.november.november15;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/11/15
 * @desc:
 **/
//卡车上的最大单元数   https://leetcode.cn/problems/maximum-units-on-a-truck/
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (numberOfBoxes < truckSize) {
                res += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                res += truckSize * numberOfUnitsPerBox;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "hello";
        if ("a".equals(a) && StringUtils.isBlank(a)){

        }
    }
}
