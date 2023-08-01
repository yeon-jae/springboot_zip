package com.in28minutes.learnspringframework.examples.a0;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
//자동으로 컴포넌트 스캔 수행
@ComponentScan("com.in28minutes.learnspringframework.examples.a1")
public class SimpleSpringContextLauncherApplication {
    public static  void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (SimpleSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}