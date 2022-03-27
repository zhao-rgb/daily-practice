package com.zxl.dailypractice.java.bookExample;

/**
 * @author zhao
 * @className Village
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class Village {
    static int waterAmount;
    int peopleNumber;
    String name;
    Village(String s){
        name=s;
    }
    static void setWaterAmount(int m){
        if(m>0) {
            waterAmount=m;
        }
    }
    void drinkWater(int n){
        if(waterAmount-n>=0){
            waterAmount=waterAmount-n;
            System.out.println(name+"喝了"+n+"升水");
        }
        else {
            waterAmount=0;
        }
    }
    static int lookWaterAmount(){
        return waterAmount;
    }
    void setPeopleNumber(int n){
        peopleNumber=n;
    }
    int getPeopleNumber(){
        return peopleNumber;
    }
}
