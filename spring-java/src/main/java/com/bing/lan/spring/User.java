package com.bing.lan.spring;

/**
 * Created by 蓝兵 on 2019/11/27.
 */

public class User {

    private String name;

    private String passWd;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passWd='" + passWd + '\'' +
                ", age=" + age +
                '}';
    }
}
