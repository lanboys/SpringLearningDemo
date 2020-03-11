package com.bing.lan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 蓝兵 on 2020/3/11.
 */

@Component
public class SomeBean {

    @Autowired
    HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}
