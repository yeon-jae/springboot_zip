package com.practice.springboot.learningspringboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/courses
/*
{
        "id":1,
        "name":'LEARN AWS',
        "author":"in28minutes"
        }

 */
//요청에서 반환할 값
//1. restAPI만들기-RestController주석 사용
@RestController
public class CurrencyConfigurationController {
    //courses , Course: id,name,author
//3.courses : 누군가 /courses를 입력하면 코스 목록을 반환
    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses(){
        return configuration;
    }

}
