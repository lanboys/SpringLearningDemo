package com.bing.lan.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by 蓝兵 on 2019/10/11.
 */
public class HelloWorld implements InitializingBean, DisposableBean {

    private String hello;
    private String world;

    public HelloWorld() {
    }

    public HelloWorld(String hello) {
        this.hello = hello;
    }

    public HelloWorld(String hello, String world) {
        this.hello = hello;
        this.world = world;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public void sayHello() {
        System.out.println("sayHello(): ");
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "hello='" + hello + '\'' +
                ", world='" + world + '\'' +
                '}';
    }

    public void destroy() throws Exception {
        System.out.println("destroy(): ");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet(): ");
    }
}
