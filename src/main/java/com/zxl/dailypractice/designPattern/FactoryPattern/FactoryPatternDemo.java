package com.zxl.dailypractice.designPattern.FactoryPattern;

/**
 * @author zhao
 * @className FactoryPatternDemo
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
//工厂模式      https://www.runoob.com/design-pattern/factory-pattern.html
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
