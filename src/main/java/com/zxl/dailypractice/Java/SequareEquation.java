package com.zxl.dailypractice.Java;

/**
 * @author zhao
 * @className SequareEquation
 * @Description TODO
 * @Date 2021/12/9
 * @Version 1.0
 **/
public class SequareEquation {
    double a,b,c;
    double root1,root2;
    boolean boo;
    public SequareEquation(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        if (a!=0){
            boo = true;
        } else {
            boo = false;
        }
    }

    public void getRoots(){
        if (boo){
            System.out.println("是一元二次方程");
            double disk = b*b-4*a*c;
            if (disk>=0){
                root1 = (-b+Math.sqrt(disk));
                root2 = (-b-Math.sqrt(disk));
                System.out.println("方程的根："+root1+","+root2);
            } else {
                System.out.println("方程没有实根");
            }
        }else {
            System.out.println("不是一元二次方程");
        }
    }
    public void setCoefficient(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        if (a!=0){
            boo = true;
        } else {
            boo = false;
        }
    }

    public static void main(String[] args) {
        SequareEquation sequareEquation = new SequareEquation(4, 5, 1);
        sequareEquation.getRoots();
        sequareEquation.setCoefficient(-3,4,5);
        sequareEquation.getRoots();
    }
}
