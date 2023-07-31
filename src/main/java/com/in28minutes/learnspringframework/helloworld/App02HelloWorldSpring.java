package com.in28minutes.learnspringframework.helloworld;

import com.in28minutes.learnspringframework.helloworld.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static  void main(String[] args){
     //1.launch a spring context or spring application

        var context=
            new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    //2.configure the things that we want Spring to manage -@confifuration
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address2"));
       // System.out.println(context.getBean(Address.class));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
    }
}
