package com.practice.springboot.learningspringboot.controller;

import com.practice.springboot.learningspringboot.dto.ContentDTO;
import com.practice.springboot.learningspringboot.entity.ContentEntity;
import com.practice.springboot.learningspringboot.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
{
        "productId":1,
        "productCode:AAA",
        "productName":"일회용마스크",
        "productPurpose":"황사, 코로나 예방",
        "productPrice":"가격"
        }

 */
//요청에서 반환할 값
//1. restAPI만들기-RestController주석 사용-spring이 알아서 컨트롤러로 인식하도록 함
@RestController
@RequestMapping ("/v1")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;

    @PostMapping("/contents")
    public ResponseEntity<ContentEntity> postContent(@RequestBody ContentDTO contentDTO) {
        try {
            // ContentDTO를 ContentEntity로 변환
            ContentEntity contentEntity = ContentEntity.contentEntity(contentDTO);

            ContentEntity savedContent = contentRepository.save(contentEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
        } catch (Exception e) {
            // 저장 도중 에러가 발생했을 때 500 Internal Server Error 상태와 함께 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   /* @GetMapping("/contents")
    public String content(ContentDTO contentDTO){
        System.out.println(contentDTO.getContentId());
        System.out.println(contentDTO.getContentName());
        System.out.println(contentDTO.getContentContent());

        return contentDTO.toString();
    }*/

    }
}
