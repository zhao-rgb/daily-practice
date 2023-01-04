package com.zxl.dailypractice.card.three.january.january3;

/**
 * @author: zhaoxl
 * @date: 2023/1/3
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String roleIds = "[\"1676\",\"22\"]";
        String[] split = roleIds.split(",");
        for(String role : split){
            String replace = role.replace("[", "")
                    .replace("\"", "")
                    .replace("]", "");
            System.out.println(replace);
        }
    }
}
