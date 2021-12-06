package com.zxl.dailypractice.DesignPattern.DecoratorPattern;

/**
 * @author zhao
 * @className ShapeDecorator
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
