package com.zxl.dailypractice.designPattern.MediatorPattern;



import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className ChatRoom
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public class ChatRoom extends AbstractChatRoom{
    private List<User> users = new ArrayList<>();

    public void register(User user){
        users.add(user);
    }

    @Override
    public void notice(String message, User user) {
        for (User u : users) {
            if(u != user){
                u.getMessage(message);
            }
        }
    }
}
