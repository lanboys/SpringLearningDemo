package com.bing.lan.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory beanFactory = new XmlBeanFactory(resource);

        //String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
        //
        //for (String postProcessorName : postProcessorNames) {
        //    Object bean = beanFactory.getBean(postProcessorName);
        //    beanFactory.addBeanPostProcessor((BeanPostProcessor) bean);
        //}
        beanFactory.addBeanPostProcessor(new HelloBeanPostProcessor());

        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        System.out.println("main(): " + helloWorld);
        HelloWorld helloWorld1 = (HelloWorld) beanFactory.getBean("helloWorld");
        System.out.println("main(): " + helloWorld1);
        HelloWorld helloWorld2 = (HelloWorld) beanFactory.getBean("helloWorld-id-2");
        System.out.println("main(): " + helloWorld2);
        Object parent = beanFactory.getBean("parent-id");
        System.out.println("main(): " + parent);

        // 手动启动spring容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //
        //HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        //System.out.println("main(): " + helloWorld);
        //
        //// 要启用注解才生效
        //SpringStartup springStartup = (SpringStartup) context.getBean("springStartup");
        //System.out.println("main(): " + springStartup);
    }
}