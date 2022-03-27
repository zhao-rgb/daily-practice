package com.zxl.dailypractice.java.bookExample;

/**
 * @author zhao
 * @className Family
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class Family {
    TV homeTV;
    void buyTV(TV tv){
        homeTV=tv;
    }
    void remoteControl(int m){
        homeTV.setChannel(m);
    }
    void seeTV(){
        homeTV.showProgram();
    }
}
