package com.zxl.dailypractice.promblem;

/**
 * @author: zhaoxl
 * @date: 2022/7/27
 * @desc:
 **/
public class Student {
    private String name;
    private int age;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void setName(String name){
        this.name=name;

    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "student [name="+name+" , "+"age="+age+"]";
    }

}
