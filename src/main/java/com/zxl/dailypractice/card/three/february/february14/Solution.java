package com.zxl.dailypractice.card.three.february.february14;

/**
 * @author: zhaoxl
 * @date: 2023/2/14
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String esSearchUrl = "http://192.168.6.16:9200" + "/pm_col_flux_" + "dateTime" +"/_search";
        String substring = esSearchUrl.substring(esSearchUrl.lastIndexOf("/",esSearchUrl.lastIndexOf("/") -1) + 1,esSearchUrl.lastIndexOf("/"));
        System.out.println(substring);
    }
}
