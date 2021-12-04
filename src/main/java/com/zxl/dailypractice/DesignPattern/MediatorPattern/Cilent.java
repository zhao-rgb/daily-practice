package com.zxl.dailypractice.DesignPattern.MediatorPattern;

/**
 * @author zhao
 * @className Cilent
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
//中介模式     https://www.lanqiao.cn/courses/1230/learning/?id=11050
public class Cilent {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        UserA userA = new UserA(chatRoom);
        UserB userB = new UserB(chatRoom);
        chatRoom.register(userA);
        chatRoom.register(userB);
        userA.sendMessage("你好！");
        userB.sendMessage("再见！");
    }
}
