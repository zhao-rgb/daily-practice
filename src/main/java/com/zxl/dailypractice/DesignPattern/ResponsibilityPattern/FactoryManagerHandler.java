package com.zxl.dailypractice.DesignPattern.ResponsibilityPattern;

/**
 * @author zhao
 * @className FactoryManagerHandler
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
public class FactoryManagerHandler extends Handler{
    @Override
    public void handlerRequest(int heaven) {
        if (heaven <= 7){
            System.out.println("厂长处理");
        } else {
            if(super.successor != null){
                super.successor.handlerRequest(heaven);
            }
        }
    }
}
