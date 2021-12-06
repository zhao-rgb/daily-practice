package com.zxl.dailypractice.DesignPattern.DecoratorPattern;

/**
 * @author zhao
 * @className Rectangle
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
