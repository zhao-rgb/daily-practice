package com.zxl.dailypractice.ailiyun;

import java.util.Optional;

/**
 * @author zhao
 * @className Option
 * @Description TODO
 * @Date 2021/12/28
 * @Version 1.0
 **/
//optional类     https://developer.aliyun.com/learning/course/20/detail/348?spm=a2c6h.21258778.0.0.189b11a6dXgboP
public class Option {
    public static void main(String[] args) {
        IMessage temp = MessageUtil.getMessage().get();
//        IMessage temp = MessageUtil.getMessage().orElse(new MessageImpl());
        MessageUtil.useMessage(temp);
    }
}

class MessageUtil{
    private MessageUtil(){}
    public static Optional<IMessage> getMessage() {
        return Optional.of(new MessageImpl());
//        return Optional.ofNullable(null);
    }
    public static void useMessage(IMessage msg){
        if (msg != null){
            System.out.println(msg.getContent());
        }
    }
}

interface IMessage{
    public String getContent();
}

class MessageImpl implements IMessage{
    @Override
    public String getContent() {
        return "zxl.hello";
    }
}
