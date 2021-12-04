package com.zxl.dailypractice.DesignPattern.MediatorPattern;

/**
 * @author zhao
 * @className User
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public abstract class User {
    protected AbstractChatRoom chatRoom;

    public User(AbstractChatRoom chatRoom){
        this.chatRoom = chatRoom;
    }

    /**
     * 发送消息
     * @param msg
     */
    public abstract void sendMessage(String msg);

    /**
     * 接受消息
     * @param msg
     */
    public abstract void getMessage(String msg);
}
