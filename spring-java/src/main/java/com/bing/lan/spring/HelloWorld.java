package com.bing.lan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 蓝兵 on 2019/10/11.
 */
@Component
public class HelloWorld {

    @Autowired
    SomeBean someBean;

    public void sayHello() {
        System.out.println("sayHello(): ");
    }

    public SomeBean getSomeBean() {
        return someBean;
    }

    public void setSomeBean(SomeBean someBean) {
        this.someBean = someBean;
    }
}
