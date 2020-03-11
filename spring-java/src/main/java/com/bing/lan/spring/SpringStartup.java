package com.bing.lan.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by 蓝兵 on 2019/10/11.
 * https://www.ibm.com/developerworks/cn/java/j-lo-spring-principle/index.html
 */
@Component
public class SpringStartup {

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        //Resource resource = new ClassPathResource("applicationContext.xml");
        //DefaultListableBeanFactory beanFactory = new XmlBeanFactory(resource);
        //HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        //System.out.println("main(): " + helloWorld);

        // 手动启动spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println("main(): " + helloWorld);

        SomeBean someBean = (SomeBean) context.getBean("someBean");
        System.out.println("main(): " + someBean);

        // 要启用注解才生效
        SpringStartup springStartup = (SpringStartup) context.getBean("springStartup");
        System.out.println("main(): " + springStartup);
    }
}