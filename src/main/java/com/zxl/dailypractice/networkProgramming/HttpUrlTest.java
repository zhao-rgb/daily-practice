package com.zxl.dailypractice.networkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhao
 * @className HttpUrlTest
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//HttpURLConnection 类的基本流程     https://www.lanqiao.cn/courses/1230/learning/?id=9473
public class HttpUrlTest {
    public static void main(String[] args) {
        try {
            //设置url
            URL shiyanlou = new URL("https://www.lanqiao.cn");
            //打开连接
            HttpURLConnection urlConnection = (HttpURLConnection)shiyanlou.openConnection();
            //设置请求方法
            urlConnection.setRequestMethod("GET");
            //设置连接超时时间
            urlConnection.setConnectTimeout(1000);
            //获取输入流
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //打印结果
            bufferedReader.lines().forEach(System.out::println);
            //关闭连接
            inputStream.close();
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
