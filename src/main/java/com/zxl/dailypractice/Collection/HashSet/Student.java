package com.zxl.dailypractice.Collection.HashSet;

/**
 * @author zhao
 * @className Student
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
public class Student {
    /**
     * 学生类
     */
    public String id;
    public String name;
    public Student(String id, String name){
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
