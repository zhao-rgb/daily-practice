package com.zxl.dailypractice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zhao
 * @className ReflectDemo
 * @Description TODO
 * @Date 2021/11/23
 * @Version 1.0
 **/
//反射       https://www.lanqiao.cn/courses/1230/learning/?id=11048
public class ReflectDemo {
    public int a;
    private int b;

    public static void main(String[] args) {
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        //输出所有域名称
        for(Field declaredField : reflectDemoClass.getDeclaredFields()) {
            //可以通过Modifier将具体的权限信息输出，否则只会显示代表权限的数值
            System.out.println("域："+declaredField.getName() +"修饰符："+
                    Modifier.toString(declaredField.getModifiers()));
        }
        //输出所有的公有域名称
        for (Field field : reflectDemoClass.getFields()) {
            System.out.println("公有域: "+field.getName()+"修饰符："+
                    Modifier.toString(field.getModifiers()));
        }
        //输出类的所有方法名
        for (Method declaredMethod : reflectDemoClass.getDeclaredMethods()) {
            System.out.println("方法："+ declaredMethod.getName()+"修饰符："+
                    Modifier.toString(declaredMethod.getModifiers()));
        }
    }

    public void fun1(){

    }
    private void fun2(){

    }
}
