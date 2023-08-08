package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//데이터로 연결
@Repository
@Transactional
public class CourseJpaRepository {
    //jpa를 활용해서 데이터베이스에 연결하려면 entityManager를 사용해야함
    @PersistenceContext
    private EntityManager entityManager;
    public void insert(Course course){
        //행을 삽입할 수 잇는 메소드
        entityManager.merge(course);
    }
    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }
    public void deleteById(long id){
        Course course= entityManager.find(Course.class,id);
        entityManager.remove(course);

    }
}
