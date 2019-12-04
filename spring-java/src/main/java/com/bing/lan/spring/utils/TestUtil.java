package com.bing.lan.spring.utils;

/**
 * Created by 蓝兵 on 2019/11/27.
 */

public class TestUtil {

    public static void main(String[] args) {
        //先进行'&&'运算，在进行'||'运算
        //int a = 1;
        //int b = 3;
        //int c = 5;
        //boolean d = true;
        //System.out.println(a > b || c > b && d);//==> false || true && true ==> true
        //System.err.println(b > a || a > c && d);//==> true || false && true ==> true
        //System.out.println(a > b || c > b && false);//==> false || true && false ==> false
        //System.out.println(b > a || c > b && false);//==> true || true && false ==>  true

        System.out.println(a(false) || b(true) && c(true));//==> false || true && true ==> true
        System.out.println("main(): -----------");
        System.out.println(a(true) || b(false) && c(true));//==> true || false && true ==> true
        System.out.println("main(): -----------");
        System.out.println(a(false) || b(true) && c(false));//==> false || true && false ==> false
        System.out.println("main(): -----------");
        System.out.println(a(true) || b(true) && c(false));//==> true || true && false ==>  true
    }

    public static boolean a(boolean b) {
        System.out.println("a(): ");
        return b;
    }

    public static boolean b(boolean b) {
        System.out.println("b(): ");
        return b;
    }

    public static boolean c(boolean b) {
        System.out.println("c(): ");
        return b;
    }
}
