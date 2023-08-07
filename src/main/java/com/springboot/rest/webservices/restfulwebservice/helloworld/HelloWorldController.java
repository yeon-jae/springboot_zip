package com.springboot.rest.webservices.restfulwebservice.helloworld;


//1.rest api 노출

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//4. RestController지정
@RestController
public class HelloWorldController {
   //2. rest api 에 url 부여 ex_ localhost:8080//hello-world 입력 가능
    //3."Hello world 반환 가능하게 "

    @GetMapping(path= "/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping(path= "/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("HELLO WORLD");
    }

    //PATH parameters
    @GetMapping(path= "/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name)
    {return new HelloWorldBean(String.format("HELLO WORLD , $s" +name));}

}
