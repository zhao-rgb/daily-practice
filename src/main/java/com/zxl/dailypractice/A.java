package com.zxl.dailypractice;

/**
 * @author zhao
 * @className A
 * @Description TODO
 * @Date 2021/11/24
 * @Version 1.0
 **/
public class A {
    public static void main(String[] args) {
        double[][] a = {{001,82.5,90,78.5},{002,75,88,92.5},{003,95,65.5,70},{004,81,72.5,86.5},{005,89,98,66}};
        int i,j;
        double sum = 0;
        for(j = 0; j < 5; j++){
            sum+=a[j][1];
            System.out.println(sum);
        }

//        A a = new A();
//        int p[]={11,12,13,14,15,16,17,18};
//        int i=0,j=0;
//        while(i++<7){
//            if(p[i]%2!=0) {
//                j+=p[i];
//            }
//        };
//        System.out.println(j);


    }


//    int  fun (int n )
//    {int i,j,p,s=0;
//        for(i=1;i<=n; i++)
//        { p=1;
//            for(j=1; j<=i;j++) {
//                p=p*j;
//                s=s+p;
//            }
//        }
//        return s;
//
//    }


}
