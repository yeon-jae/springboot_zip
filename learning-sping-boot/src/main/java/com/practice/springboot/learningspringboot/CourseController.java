package com.practice.springboot.learningspringboot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
public class CourseController {
    //courses , Course: id,name,author
//3.courses : 누군가 /courses를 입력하면 코스 목록을 반환
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"Learn AWS","in28minutes"),
                new Course(2,"Learn Devops","in28minutes"),
                new Course(3,"Learn Azure","in28minutes"),
                new Course(4,"Learn","in28minutes")
                );
    }

}
