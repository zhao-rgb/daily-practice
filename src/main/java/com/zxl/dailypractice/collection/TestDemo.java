package com.zxl.dailypractice.collection;

/**
 * @author zhao
 * @className TestDemo
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//定义泛型类    https://www.lanqiao.cn/courses/1230/learning/?id=9469
public class TestDemo {

    public static void main(String[] args) {
        // 定义泛型类 Test 的一个Integer版本
        Test<Integer> intOb = new Test<Integer>(88);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value=" + i);
        System.out.println("----------------------------------");
        // 定义泛型类Test的一个String版本
        Test<String> strOb = new Test<String>("Hello Gen!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value=" + s);
    }
}

//使用T代表类型，无论何时都没有比这更具体的类型来区分它。如果有多个类型参数，我们可能使用字母表中T的临近的字母，比如S。
class Test<T>{
    private T ob;
    //定义泛型成员变量，定义完类型参数后，可以在定义位置之后的方法的任意地方使用类型参数，就像使用普通的类型一样。
    //注意，父类定义的类型参数不能被子类继承。
    //构造函数
    public Test(T ob){
        this.ob = ob;
    }

    //getter方法
    public T getOb(){
        return ob;
    }

    //setter 方法
    public void setOb(T ob){
        this.ob = ob;
    }

    public void showType(){
        System.out.println("T的实际类型是："+ob.getClass().getName());
    }
}


