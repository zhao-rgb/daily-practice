package com.zxl.dailypractice.designPattern.MediatorPattern;



/**
 * @author zhao
 * @className AbstractChatRoom
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public abstract class AbstractChatRoom {
    public abstract void notice(String message, User user);
}
