package com.bing.lan.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by 蓝兵 on 2019/11/21.
 */

public class UserFactoryBean implements FactoryBean<User> {

    private String name;

    private String passWd;

    private int age;

    public User getObject() throws Exception {
        if (age <= 0) {
            throw new Exception("年龄输入错误");
        }
        User user = new User();
        user.setAge(age);
        user.setPassWd(passWd);
        user.setName(name);

        return user;
    }

    public Class<User> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }

    //------------------------------------
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
