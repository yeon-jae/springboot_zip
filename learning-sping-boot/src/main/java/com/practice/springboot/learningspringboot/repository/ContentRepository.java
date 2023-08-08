package com.practice.springboot.learningspringboot.repository;

import com.practice.springboot.learningspringboot.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity,Long> {
}
