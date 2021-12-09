package com.zxl.dailypractice.Java;

/**
 * @author zhao
 * @className MainClass
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class MainClass {
    public static void main(String[] args) {
        TV haierTV=new TV();
        haierTV.setChannel(5);
        System.out.println("haierTV的频道是"+haierTV.getChannel());
        Family zhangSanFamily=new Family();
        zhangSanFamily.buyTV(haierTV);
        System.out.println("zhangSanFamily开始看电视节目");
        zhangSanFamily.seeTV();
        int m=2;
        System.out.println("zhangSanFamily将电视更换到"+m+"频道");
        zhangSanFamily.remoteControl(m);
        System.out.println("haierTV的频道是"+haierTV.getChannel());
        System.out.println("zhangSanFamily再看电视节目");
        zhangSanFamily.seeTV();
    }
}
