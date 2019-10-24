package com.bing.lan.spring;

/**
 * Created by 蓝兵 on 2019/10/24.
 */

public class Hello {

    private String lan;

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "lan='" + lan + '\'' +
                '}';
    }
}
