package com.zxl.dailypractice.card.three.april.april10;

/**
 * @author: zhaoxl
 * @date: 2023/4/10
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        LocalDateTime startTime = LocalDateTime.now();
//        // some time-consuming operation here
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i);
//        }
//        LocalDateTime endTime = LocalDateTime.now();
//        Duration duration = Duration.between(startTime, endTime);
//        System.out.println("Time difference: " + duration.toMillis() + " milliseconds");


        long startTime = System.currentTimeMillis();
        // code for event 1
        for (int i = 0; i < 500; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Time elapsed for event 1: " + timeElapsed + " milliseconds");

        String[] split = "[\"e5a6b590-0d0c-4c75-b061-34703d803f0a\",\"1\"]".replace("[", "").replace("]", "").replace("\"","").split(",");
        String s = split[0];
        System.out.println(s);
    }

}
