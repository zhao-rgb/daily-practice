package com.zxl.dailypractice.card.three.february.february10;

/**
 * @author: zhaoxl
 * @date: 2023/2/10
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String a = "view/nms/data/download/iprandevtmp//NM/NM_ipranDeviceInfo_compare_20230208.json.gz";
        String substring = a.substring(a.lastIndexOf("/") + 1);
        System.out.println(substring);
    }
}
