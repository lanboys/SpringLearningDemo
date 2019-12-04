package com.bing.lan.spring;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBeanFactory {

    public static SomeBean staticCreate() {
        System.out.println("staticCreate(): 工厂方法构建bean");
        SomeBean someBean = new SomeBean();
        someBean.init();
        return someBean;
    }

    public SomeBean create() {
        System.out.println("create(): 工厂方法构建bean");
        return new SomeBean();
    }
}
