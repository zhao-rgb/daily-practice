package com.zxl.dailypractice.Java;

import java.util.Random;
import java.util.Scanner;

/**
 * @author zhao
 * @className numbergame
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
//猜数游戏
public class numbergame {
    public static void main(String args[]){
        Scanner reader =new Scanner(System.in);
        Random random=new Random();
        System.out.println("给你一个1-100之间的整数,猜猜这个数");
        int realNumber=random.nextInt(100)+1;
        int YourGuess=0;
        System.out.print("输入您的猜测:");
        YourGuess=reader.nextInt();         //输入你猜测得数
        while(YourGuess!=realNumber)
        {
            if(YourGuess>realNumber)
            {
                System.out.println("猜大了，再输入你大猜测");
                YourGuess=reader.nextInt();
            }
            else {
                System.out.println("猜小了，再输入你大猜测");
                YourGuess=reader.nextInt();
            }
        }
        System.out.println("恭喜你猜对了");
    }
}
