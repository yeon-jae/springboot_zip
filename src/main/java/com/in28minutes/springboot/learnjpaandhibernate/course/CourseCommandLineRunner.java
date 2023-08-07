package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //jdbc 사용할때
    //private CourseJdbcRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        //쿼리를 실행하게 됨
        repository.save(new Course(1,"Learn AWS JPA!!","in28Minutes"));
        repository.save(new Course(2,"Learn AZURE JPA!","in28Minutes"));
        repository.save(new Course(3,"Learn DevOPs JPA!","in28Minutes"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findByAuthor("in28Minutes"));
    }
}
