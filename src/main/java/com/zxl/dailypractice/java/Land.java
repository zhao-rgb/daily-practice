package com.zxl.dailypractice.java;

/**
 * @author zhao
 * @className Land
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class Land {
    public static void main(String[] args) {
        Village.setWaterAmount(200);
        int leftWater=Village.waterAmount;
        System.out.println("水井中有"+leftWater+"升水");
        Village zhaoZhuang,maJiaHeZi;
        zhaoZhuang=new Village("赵庄");
        maJiaHeZi=new Village("马家河子");
        zhaoZhuang.setPeopleNumber(80);
        maJiaHeZi.setPeopleNumber(120);
        zhaoZhuang.drinkWater(50);
        leftWater=maJiaHeZi.lookWaterAmount();
        String name=maJiaHeZi.name;
        System.out.println(name+"发现水井中有"+leftWater+"升水");
        maJiaHeZi.drinkWater(100);
    }
}
