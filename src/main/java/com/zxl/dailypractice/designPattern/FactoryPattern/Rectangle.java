package com.zxl.dailypractice.designPattern.FactoryPattern;

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
        System.out.println("Inside Rectangle::draw() method.");
    }
}
