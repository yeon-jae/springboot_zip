package com.practice.springboot.learningspringboot.repository;

import com.practice.springboot.learningspringboot.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
{

}