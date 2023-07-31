package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record 생성

record Person(String name, int age){
};
record  Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {
//spring 설정 클래스

    @Bean
    public String name(){
        return "Yeon-Jae";
    }

    @Bean
    public int age(){return 25;}


    @Bean
    public Person person(){
        var person=new Person("Ravi",20);
        return person;
    }

    @Bean
    public Address address(){
        var address= new Address("korea","seoul");
        return address;
    }


}
