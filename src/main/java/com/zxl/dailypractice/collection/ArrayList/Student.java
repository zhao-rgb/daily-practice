package com.zxl.dailypractice.collection.ArrayList;

/**
 * @author zhao
 * @className Student
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
public class Student {
    public String id;
    public String name;
    public Student(String id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
