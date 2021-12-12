package com.zxl.dailypractice.designPattern.DecoratorPattern;

/**
 * @author zhao
 * @className DecoratorPatternDemo
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
// 装饰器模式      https://www.runoob.com/design-pattern/decorator-pattern.html
//没懂！！！
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
