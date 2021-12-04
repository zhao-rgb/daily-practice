package com.zxl.dailypractice.Collection.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhao
 * @className PD
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//HashSet    https://www.lanqiao.cn/courses/1230/learning/?id=9469
public class PD {
    /*
     * 项目组长类
     */
    public String id;
    public String name;
    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    public Set<Student> students;
    public PD(String id, String name){
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}
