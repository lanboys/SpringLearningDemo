package com.bing.lan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 蓝兵 on 2019/10/11.
 * https://www.ibm.com/developerworks/cn/java/j-lo-spring-principle/index.html
 */
public class SpringStartup {

  public static void main(String[] args) {

    // 手动启动spring容器
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    BeanB beanB = (BeanB) context.getBean("beanB");
    System.out.println("main(): " + beanB);
  }
}