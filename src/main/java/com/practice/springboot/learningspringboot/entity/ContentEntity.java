package com.practice.springboot.learningspringboot.entity;

import com.practice.springboot.learningspringboot.dto.ContentDTO;
import com.practice.springboot.learningspringboot.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "contents")
public class ContentEntity {//table 역할
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private long contentId;
    @Column
    private String contentName;

    @Column
    private String contentContent;

    public static ContentEntity contentEntity(ContentDTO contentDTO){
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setContentId(contentDTO.getContentId());
        contentEntity.setContentName(contentDTO.getContentName());
        contentEntity.setContentContent(contentDTO.getContentContent());
        return contentEntity;
    }

}
