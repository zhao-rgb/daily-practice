package com.zxl.dailypractice.Io;

import java.io.*;

/**
 * @author zhao
 * @className ReadWriteObject
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//读写对象      https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class ReadWriteObject {
    public static void main(String[] args) {
        File file = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\user.file");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            //将匿名对象 写入到file中，注意：被写入的对象必须实现了Serializable接口
            objectOutputStream.writeObject(new User("shiyanlou","password"));
            objectOutputStream.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        //读取文件 打开输入流
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            //将信息还原为user实例
            User user = (User) objectInputStream.readObject();
            //打印user信息  和上面创建的匿名对象的信息一致
            System.out.println(user.toString());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //静态内部类 必须实现Serializable
    static class User implements Serializable{
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
