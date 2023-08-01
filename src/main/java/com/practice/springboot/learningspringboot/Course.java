package com.practice.springboot.learningspringboot;

public class Course {
    //2.포함할 모든 속성을 정의
    private long id;
    private String name;
    private String author;

    //constructor
    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    //getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }


    //tostring

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + '}';
    }
}
