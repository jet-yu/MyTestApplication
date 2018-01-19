package com.example.test;

import org.json.JSONException;

import java.math.BigDecimal;

/**
 * Created by xu.yu on 16/4/27.
 */
public class Test {
    public static void main(String[] args) throws JSONException {
        String abc = "1230**198.90";
        String[] strs = abc.split("\\*\\*");
        System.out.println(strs[0]+"--"+strs[1]);
        String str = "{0.45,99}";
        Test a = new Test();



    }

    public static String add(String v1, String v2) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] v1Array = v1.trim().replace(",", "").replaceFirst("[0-9]", " $0").split(" ");
        String[] v2Array = v2.trim().replace(",","").replaceFirst("[0-9]", " $0").split(" ");
        stringBuffer.append(v1Array[0]);
        BigDecimal b1 = new BigDecimal(v1Array[v1Array.length - 1]);
        BigDecimal b2 = new BigDecimal(v2Array[v2Array.length - 1]);
        stringBuffer.append(b1.add(b2).doubleValue());
        return stringBuffer.toString();
    }

    public static String reduce(String v1,String v2){

        try {
            StringBuffer stringBuffer = new StringBuffer();
            String[] v1Array = v1.trim().replace(",", "").replaceFirst("[0-9]", " $0").split(" ");
            stringBuffer.append(v1Array[0]);
            BigDecimal b1 = new BigDecimal(v1Array[v1Array.length - 1]);
            BigDecimal b2 = new BigDecimal(v2.trim());
            return  stringBuffer.append(b1.subtract(b2).doubleValue()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return v1;
        }
    }

}
