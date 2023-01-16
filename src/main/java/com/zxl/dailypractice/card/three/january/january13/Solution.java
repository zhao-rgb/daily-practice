package com.zxl.dailypractice.card.three.january.january13;

/**
 * @author: zhaoxl
 * @date: 2023/1/13
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String[] roleIds = {"111","222","333"};
        for(String role : roleIds){
            System.out.println(role);
            String replace = role.replace("[", "")
                    .replace("\"", "")
                    .replace("]", "");
        }
    }
}
