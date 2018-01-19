package com.example.administrator.mytestapplication.activity.xuliehua;

import java.io.Serializable;
/**
 *属性类，用来存储数据，继承接口Serializable，但是什么方法都不用重写！
 */
public class People implements Serializable{
    //定义基本信息
    String name;
    String password;
    int age;

    //无参构造方法
    public People() {
        super();
    }

    //有参构造方法，方便数据写入
    public People(String name, String password, int age) {
        super();
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}