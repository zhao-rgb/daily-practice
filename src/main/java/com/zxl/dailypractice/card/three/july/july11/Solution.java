package com.zxl.dailypractice.card.three.july.july11;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhaoxl
 * @date: 2023/7/11
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        List<User> objects = new ArrayList<>();
        User user1 = new User("1", "22");
        User user2 = new User("2", "22");
        objects.add(user1);
        objects.add(user2);
//        objects.forEach(e -> {
//            e.setName("zxl");
//            e.setAge("20");
//        });
//        System.out.println(objects);
        Map<Object, Object> map = new HashMap<>();
        map = objects.stream().collect(Collectors.toMap(l -> l.getName(),l ->l
        ));
        System.out.println(map);
    }
}
