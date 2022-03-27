package com.zxl.dailypractice.java.bookExample;

import java.util.Scanner;

/**
 * @author zhao
 * @className PalindromeNumber
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
//回文数
public class PalindromeNumber {
    public static void main(String[] args) {
        int number=0,d5,d4,d3,d2,d1;
        Scanner reader=new Scanner(System.in);
        System.out.println("输入一个1至99999之间的数");
        number=reader.nextInt();
        if(number>=1&&number<=99999)
        {
            d5=number/10000;        //万位
            d4=number/1000%10;      //千位
            d3=number%10000%1000/100;      //百位
            d2=number%10000%1000%100/10;       //十位
            d1=number%10;           //个位
            System.out.println(d1);
            if(d5!=0)
            {
                System.out.println(number+"是5位数");
                if(d1==d5&&d2==d4) {
                    System.out.println(number+"是回文数");
                } else {
                    System.out.println(number+"不是回文数");
                }
            }
            else if(d4!=0)
            {
                System.out.println(number+"是4位数");
                if(d4==d1&&d3==d2) {
                    System.out.println(number+"是回文数");
                } else {
                    System.out.println(number+"不是回文数");
                }
            }
            else if(d3!=0)
            {
                System.out.println(number+"是3位数");
                if(d1==d3) {
                    System.out.println(number+"是回文数");
                } else {
                    System.out.println(number+"不是回文数");
                }
            }
            else if(d2!=0)
            {
                System.out.println(number+"是2位数");
                if(d1==d2) {
                    System.out.println(number+"是回文数");
                } else {
                    System.out.println(number+"不是回文数");
                }
            }
            else if(d1!=0)
            {
                System.out.println(number+"是1位数");
                System.out.println(number+"是回文数");
            }
        }
        else
        {
            System.out.println("这是不在1至99999之间的数");
        }
    }
}
