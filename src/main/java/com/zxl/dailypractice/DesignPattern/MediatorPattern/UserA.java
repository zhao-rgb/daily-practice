package com.zxl.dailypractice.DesignPattern.MediatorPattern;

/**
 * @author zhao
 * @className UserA
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public class UserA extends User{
    public UserA(AbstractChatRoom chatRoom){
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("用户A发送 " + msg);
        chatRoom.notice(msg,this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("用户A收到 " + msg);
    }
}
