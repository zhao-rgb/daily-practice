package com.zxl.dailypractice.DesignPattern.MediatorPattern;

/**
 * @author zhao
 * @className UserB
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public class UserB extends User{
    public UserB(AbstractChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("用户B发送 " + msg);
        chatRoom.notice(msg, this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("用户B收到 " + msg);
    }
}
