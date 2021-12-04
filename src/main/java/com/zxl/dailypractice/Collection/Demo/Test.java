package com.zxl.dailypractice.Collection.Demo;

/**
 * @author zhao
 * @className Test
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
public class Test {
    //注意：定义带类型参数的方法，其主要目的是为了表达多个参数以及返回值之间的关系。
    // 例如本例子中T和S的继承关系， 返回值的类型和第一个类型参数的值相同。
    public<T,S extends T> T testDemo(T t, S s){
        System.out.println("我是 T 类型，我的类型是" + t.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + s.getClass().getName());
        return t;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test = new Test();
        Dog d = new Dog();
        Animal a0 = new Animal();
        Animal a1 = test.testDemo(a0,d);
        System.out.println("我是对象 a1，我的类型是" + a1.getClass().getName());
    }
}
