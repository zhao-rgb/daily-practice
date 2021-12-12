package com.zxl.dailypractice.generics;

import java.time.LocalTime;

/**
 * @author zhao
 * @className People
 * @Description TODO
 * @Date 2021/12/12
 * @Version 1.0
 **/
//泛型  java书上462页的例子
public class People<E> {
    E friend;
    public void setFriend(E object){
        friend = object;
    }

    public E getFriend() {
        return friend;
    }

    public static void main(String[] args) {
        People<LocalTime> zhang = new People<>();
        zhang.setFriend(LocalTime.now());
        LocalTime zhangFriend = zhang.getFriend();
        System.out.println(zhangFriend);
        People<Double> doublePeople = new People<>();
        doublePeople.setFriend(1.68);
        Double friend = doublePeople.getFriend();
        System.out.println(friend);
    }
}
