package com.practice.springboot.learningspringboot.repository;

import com.practice.springboot.learningspringboot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
