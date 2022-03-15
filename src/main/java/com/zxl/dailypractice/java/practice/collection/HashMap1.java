package com.zxl.dailypractice.java.practice.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author zhao
 * @className HashMap
 * @Description TODO
 * @Date 2022/3/15
 * @Version 1.0
 **/
// 使用 Collection 类的 iterator() 方法来遍历集合   https://www.twle.cn/l/yufei/java/java-basic-collection-iterate.html
public class HashMap1 {
    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<String,String>();
        hMap.put("1","lst");
        hMap.put("2", "2nd");
        hMap.put("3", "3rd");
        Collection c1 = hMap.values();
        Iterator itr = c1.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
