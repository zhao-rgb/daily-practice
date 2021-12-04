package com.zxl.dailypractice.DesignPattern.ResponsibilityPattern;

/**
 * @author zhao
 * @className Handler
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
public abstract class Handler {
    /*
    下一个处理者
     */
    protected Handler successor;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handlerRequest(int heaven);
}
