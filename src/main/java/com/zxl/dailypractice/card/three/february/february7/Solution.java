package com.zxl.dailypractice.card.three.february.february7;

/**
 * @author: zhaoxl
 * @date: 2023/2/7
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        //去除数字
//        String REGEX = "[^0-9]";
//        String ticketStr = "c11";
//        String ticket = Pattern.compile(REGEX).matcher(ticketStr).replaceAll("").trim();
//        System.out.println(ticket);
        String a = "display current-configuration\\r\\n!Software Version V800R011C10SPC800\\r\\n";
        System.out.println(a);
        String fileContent = a.replaceAll("\r\n",System.getProperty("line.separator"));
        System.out.println(fileContent);
    }
}
