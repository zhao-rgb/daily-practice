package com.zxl.dailypractice.card.three.february.february21;

/**
 * @author: zhaoxl
 * @date: 2023/2/21
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        int pageNum = 28;
        int pageSize = 10;
        int startNumNew = pageSize * (pageNum-1);
//        if(pageNum==1){//第一页时
//            startNumNew = pageSize * (pageNum-1);
//        }else{
//            startNumNew = pageSize * (pageNum -1);
//        }
        System.out.println("--------------startNumNew="+startNumNew+",pageSizeNew="+ pageSize);
    }
}
