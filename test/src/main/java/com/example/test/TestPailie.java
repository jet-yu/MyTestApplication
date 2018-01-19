package com.example.test;

import java.util.ArrayList;

public class TestPailie {

    public static  void main(String[] args){
        String[] buf = new String[] { "1", "2", "3","4","5" };
        ArrayList<String> keys = new ArrayList<String>();
        permutation(buf, 0, buf.length - 1, keys);
        System.out.println(keys.toString() + "size:" + keys.size());
        print();


    }

    public static void print(){
        int a = 0/10;
        System.out.println(a);
        print2();
    }
    public static  void print2(){
        System.out.println("print2");
        System.out.println("print2");
        System.out.println("print2");
        System.out.println("print2");
    }



    public static void permutation(String[] buf, int start, int end,ArrayList<String> keys) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <= end; i++) {
                if(i!=end)stringBuilder.append(buf[i]+"_");
                else stringBuilder.append(buf[i]);
            }
            keys.add(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                String temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;

                permutation(buf, start + 1, end,keys);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

}