package utils;


import java.math.BigDecimal;

/**
 * Created by xu.yu
 *
 * @date 16/5/19.
 * @update
 * @function
 */
public class Test  {

    public static String getNum(String kgNum){
        java.text.DecimalFormat df = new java.text.DecimalFormat("#");
        BigDecimal b1 = new BigDecimal(kgNum);
        BigDecimal b2 = new BigDecimal("1000");
        return  df.format(b1.multiply(b2));
    }


    public static void main(String[] args){
        String s ="0.1";
        String s1 = "1234567890.012";
        String s2 = "1.001";

        System.out.println(getNum(s));
        System.out.println(getNum(s1));
        System.out.println(getNum(s2));






//        String a = "1.1456";
//        int num = a.lastIndexOf(".");
//        System.out.println(a.substring(0,num+4));
//
//        String b = a.substring(0,num)+a.substring(num+1);
//        System.out.println(b);
//
//        System.out.println(a.indexOf("."));
//        System.out.println(a.indexOf(".",a.indexOf(".")+1));
    }
}
