package com.zxl.dailypractice.DesignPattern.FactoryPattern;

/**
 * @author zhao
 * @className Square
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
