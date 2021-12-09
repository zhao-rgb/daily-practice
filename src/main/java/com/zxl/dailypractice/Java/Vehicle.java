package com.zxl.dailypractice.Java;

/**
 * @author zhao
 * @className Vehicle
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class Vehicle {
    double speed;
    int power;
    void speedUp(int s){
        speed=speed+s;
    }
    void speedDown(int d){
        speed=speed-d;
    }
    void setPower(int p){
        power=p;
    }
    int getPower(){
        return power;
    }
    double getSpeed(){
        return speed;
    }
}
