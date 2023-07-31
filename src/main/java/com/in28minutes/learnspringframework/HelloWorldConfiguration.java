package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record 생성

record Person(String name, int age, Address address){
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
        var person=new Person("Ravi",20,new Address("bakerst","london"));
        return person;
    }
    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        return new Person(name,age,address3);
    }
    //메소드 이름 변경
    @Bean(name = "address2")
    public Address address(){
        var address= new Address("korea","seoul");
        return address;
    }

    @Bean(name = "address3")
    public Address address3(){
        var address= new Address("hong-d","asia");
        return address;
    }

}
