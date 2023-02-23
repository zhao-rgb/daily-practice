package com.zxl.dailypractice.card.three.february.february21;

/**
 * @author: zhaoxl
 * @date: 2023/2/21
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        int pageNum = 2;
        int pageSize = 10;
        int startNumNew = pageSize * (pageNum-1);
        int pageSizeNew = pageSize;
        if(pageNum==1){//第一页时
            pageSizeNew = pageSize-1;
        }else{
            startNumNew = startNumNew-1;
        }
        System.out.println("--------------startNumNew="+startNumNew+",pageSizeNew="+pageSizeNew);
    }
}
