package com.zxl.dailypractice.designPattern.FactoryPattern;

/**
 * @author zhao
 * @className Circle
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
