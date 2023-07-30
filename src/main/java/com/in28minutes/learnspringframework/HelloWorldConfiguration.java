package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
//spring 설정 클래스

    @Bean
    public String name(){
        return "Yeon-Jae";
    }
}
