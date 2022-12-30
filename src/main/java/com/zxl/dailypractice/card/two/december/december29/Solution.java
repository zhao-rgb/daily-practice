package com.zxl.dailypractice.card.two.december.december29;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author: zhaoxl
 * @date: 2022/12/27
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        int number = new Random().nextInt(256);

        System.out.println("GigabitEthernet"+ (new Random().nextInt(10)+1)+"/"+ (new Random().nextInt(10)+1)
                +"/" + (new Random().nextInt(20)+1));

        String[] beforeShuffle = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        System.out.println(result);

    }
}
