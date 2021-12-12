package com.zxl.dailypractice.designPattern.DecoratorPattern;

/**
 * @author zhao
 * @className RedShapeDecorator
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }

}
