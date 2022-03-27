package com.zxl.dailypractice.java.practice.generics;

/**
 * @author zhao
 * @className demo2
 * @Description TODO
 * @Date 2022/3/27
 * @Version 1.0
 **/
//下限
/**
 * <?> 无限制通配符
 * <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
 * <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
 *
 * // 使用原则《Effictive Java》
 * // 为了获得最大限度的灵活性，要在表示 生产者或者消费者 的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
 * 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
 * 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
 * 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。
 */
public class demo2 {
    public static void main(String[] args) {
        Info2<String> i1 = new Info2<>();
        Info2<Object> i2 = new Info2<Object>();
        i1.setVar("hello");
        i2.setVar(new Object());
        fun(i1);
        fun(i2);
    }
    public static void fun(Info2<? super String> temp){
        System.out.println(temp + ", ");
    }

}
class Info2<T>{
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    @Override
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}

