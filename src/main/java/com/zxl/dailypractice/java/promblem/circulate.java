package com.zxl.dailypractice.java.promblem;

/**
 * @author zhao
 * @className circlute
 * @Description TODO
 * @Date 2021/12/26
 * @Version 1.0
 **/
public class circulate {
    //求1!+2!...+10!
    public int getSum(){
        int sum = 0,a=1,i =1;
        while (i<=10){
            sum += a;
            i++;
            a=a*i;
        }
        return sum;
    }

    //100以内的全部素数
    public void prime(){
        int i,j;
        for (j = 2; j <= 100; j++) {
            for (i = 2; i <=j/2 ; i++) {
                if (j%i==0){
                    break;
                }
            }
            if (i>j/2){
                System.out.print(" " +j);
            }
        }
    }

    //前20项和
    public double sums(){
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            int s=1;
            for (int j = 1; j <=i ; j++) {
                s=s*j;
            }
            sum+=1.0/s;
        }
        return sum;
    }

    //1000以内的完数
    public void completion() {
        int sum=0,i,j;
        for (i=1;i<=1000;i++) {
            for (j=1,sum=0;j<i;j++) {
                if (i%j==0){
                    sum=sum+j;
                }
            }
            if (sum==i){
                System.out.println("完数："+i);
            }
        }
    }

    //8+88+888+...前10项和
    public long getsums(){
        int m=8,item=m,i=1;
        long sum = 0;
        for (i=1,sum=0,item=m;i<=10;i++) {
            sum=sum+item;
            item=item*10+m;
        }
        return sum;
    }

    //最大正整数
    public int shu(){
        int n=1;
        long sum=0;
        while (true){
            sum=sum+n;
            n++;
            if (sum>=8888){
                break;
            }
        }
        return n-1;
    }

    public static void main(String[] args) {
        circulate circulate = new circulate();
        int sum = circulate.getSum();
        System.out.println(sum);
        circulate.prime();
        System.out.println();
        double sums = circulate.sums();
        System.out.println(sums);
        circulate.completion();
        long getsums = circulate.getsums();
        System.out.println(getsums);
        int shu = circulate.shu();
        System.out.println(shu);
    }
}
