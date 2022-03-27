package com.zxl.dailypractice.java.practice.generics;

/**
 * @author zhao
 * @className demo1
 * @Description TODO
 * @Date 2022/3/27
 * @Version 1.0
 **/
//上限  https://pdai.tech/md/java/basic/java-basic-x-generic.html
public class demo1 {
    public static void main(String[] args) {
        Info<Integer> i1 = new Info<>();
    }
}

class Info<T extends Number>{
    private T var;
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
