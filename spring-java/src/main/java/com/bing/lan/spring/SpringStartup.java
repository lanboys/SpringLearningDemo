package com.bing.lan.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        //for (String postProcessorName : postProcessorNames) {
        //    Object bean = beanFactory.getBean(postProcessorName);
        //    beanFactory.addBeanPostProcessor((BeanPostProcessor) bean);
        //}
        beanFactory.addBeanPostProcessor(new HelloBeanPostProcessor());

        //https://yq.aliyun.com/articles/639632

        /**
         * allowEagerInit: 控制是否允许 FactoryBean 进行 [初始化] , 以获取 Bean 的 class type
         * 初始化： 可能会完全初始化，并且注册到 BeanFactory, 或者只是简单初始化获取 class type ,最终不注册到 BeanFactory
         */
        String[] someBeans = beanFactory.getBeanNamesForType(SomeBean.class, true, false);
        System.out.println("main(): " + Arrays.toString(someBeans));

        String[] users = beanFactory.getBeanNamesForType(User.class, true, false);
        System.out.println("main(): " + Arrays.toString(users));

        String[] userFactoryBeans = beanFactory.getBeanNamesForType(UserFactoryBean.class, true, false);
        System.out.println("main(): " + Arrays.toString(userFactoryBeans));

        SomeBean someBean = (SomeBean) beanFactory.getBean("someBean");
        System.out.println("main(): " + someBean);

        SomeBean staticSomeBean = (SomeBean) beanFactory.getBean("staticSomeBean");
        System.out.println("main(): " + staticSomeBean);

        //HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        //System.out.println("main(): " + helloWorld);
        //
        //HelloWorld helloWorld2 = (HelloWorld) beanFactory.getBean("helloWorld2");
        //System.out.println("main(): " + helloWorld2);

        User user = (User) beanFactory.getBean("user");
        System.out.println("main(): " + user);

        UserFactoryBean factoryBean = (UserFactoryBean) beanFactory.getBean("&user");
        System.out.println("main(): " + factoryBean);

        // 手动启动spring容器
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        //        "applicationContext.xml") {
        //    public void prepareRefresh() {
        //        super.prepareRefresh();
        //        addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
        //            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //                System.out.println("postProcessBeanFactory(): " + beanFactory);
        //            }
        //        });
        //    }
        //};

        //UserFactoryBean factoryBeanUser = (UserFactoryBean) context.getBean("factoryBeanUser");
        //System.out.println("main(): " + factoryBeanUser);
        //
        //HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        //System.out.println("main(): " + helloWorld);

        // 要启用注解才生效
        //SpringStartup springStartup = (SpringStartup) context.getBean("springStartup");
        //System.out.println("main(): " + springStartup);
    }
}