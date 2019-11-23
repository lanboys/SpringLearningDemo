package com.bing.lan.spring.aop;

/**
 * Created by 蓝兵 on 2019/11/21.
 */

public class AopServiceImpl implements AopService {

    @Override
    public void fooA(String msg) {
        System.out.println("fooA() msg: " + msg);
    }

    @Override
    public void barA() {
        System.out.println("barA(): ");
    }

    @Override
    public void setA(String msg) {
        System.out.println("setA(): " + msg);
    }
}