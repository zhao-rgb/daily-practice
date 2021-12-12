package com.zxl.dailypractice.designPattern.ResponsibilityPattern;

/**
 * @author zhao
 * @className BossHandler
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
public class BossHandler extends Handler{
    @Override
    public void handlerRequest(int heaven) {
        if(heaven <= 15){
            System.out.println("老板处理");
        }else {
            if (super.successor != null){
                super.successor.handlerRequest(heaven);
            }
        }
    }
}
