package com.zxl.dailypractice.java.practice.structure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author zhao
 * @className Main
 * @Description TODO
 * @Date 2022/3/15
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("8");
        lList.add("6");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        lList.subList(2,4).clear();
        //删除链表中的元素
        System.out.println(lList);


        //获取向量元素的索引值
        Vector v = new Vector();
        v.add("X");
        v.add("M");
        v.add("D");
        v.add("A");
        v.add("O");
        Collections.sort(v);
        System.out.println(v);
        int index = Collections.binarySearch(v,"D");
        System.out.println(index);
    }
}
