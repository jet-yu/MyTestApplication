package com.example.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xu.yu
 *
 * @date 16/5/9.
 * @update
 * @function
 */
public class TestJava {
    public static void main(String[] args) throws JSONException {
        String abc ="{\"number\":[1,2,3]}";
        JSONObject jsonOBJ  = new JSONObject(abc);
        JSONArray jsonArray = (JSONArray) jsonOBJ.get("number");


        for(int i=0;i<jsonArray.length();i++){
            int s =  jsonArray.getInt(i);
            System.out.println(s);
        }
    }
}
