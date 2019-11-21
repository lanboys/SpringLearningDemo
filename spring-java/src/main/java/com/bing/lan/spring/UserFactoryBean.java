package com.bing.lan.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by 蓝兵 on 2019/11/21.
 */

public class UserFactoryBean implements FactoryBean<UserFactoryBean> {

    private String name;

    private String passWd;

    private int age;

    @Override
    public UserFactoryBean getObject() throws Exception {
        if (age <= 0) {
            throw new Exception("年龄输入错误");
        }
        return this;
    }

    @Override
    public Class<UserFactoryBean> getObjectType() {
        return UserFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

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
        return "UserFactoryBean{" +
                "name='" + name + '\'' +
                ", passWd='" + passWd + '\'' +
                ", age=" + age +
                '}';
    }
}
