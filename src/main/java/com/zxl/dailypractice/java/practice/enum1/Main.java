package com.zxl.dailypractice.java.practice.enum1;

/**
 * @author zhao
 * @className Main
 * @Description TODO
 * @Date 2022/3/14
 * @Version 1.0
 **/
//Enum（枚举）构造函数及方法的使用
public class Main {
    public static void main(String[] args) {
        System.out.println("所有汽车的价格：");
        for (Car c : Car.values()){
            System.out.println(c+"需要"+c.getPrice()+"千美元");
        }
    }
}

enum Car{
    lamborghini(900),tata(2),audi(50),fiat(15),honda(12);
    private int price;
    Car(int p){
        price = p;
    }
    int getPrice(){
        return price;
    }
}
