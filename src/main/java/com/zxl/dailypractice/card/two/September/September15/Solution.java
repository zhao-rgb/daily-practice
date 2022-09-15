package com.zxl.dailypractice.card.two.September.September15;

import java.io.IOException;

/**
 * @author: zhaoxl
 * @date: 2022/9/14
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (IOException e){
            System.out.println("hh");
        } catch (Exception e){
            System.out.println("dd");
        }
    }
}
