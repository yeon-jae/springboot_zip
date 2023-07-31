package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PackMan;
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
        System.out.println(context.getBean("address"));
    }
}
