package com.practice.springboot.learningspringboot.controller;

import com.practice.springboot.learningspringboot.dto.ContentDTO;
import com.practice.springboot.learningspringboot.entity.ContentEntity;
import com.practice.springboot.learningspringboot.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    }
    @GetMapping("/contents/{contentId}")
        public ResponseEntity<ContentEntity> getContent(@PathVariable Long contentId) {
            try {
                Optional<ContentEntity> optionalContent = contentRepository.findById(contentId);
                if (optionalContent.isPresent()) {
                    ContentEntity contentEntity = optionalContent.get();
                    return ResponseEntity.ok(contentEntity);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    @DeleteMapping("/contents/{contentId}")
    public ResponseEntity<String> deleteContent(@PathVariable Long contentId) {
        try {
            Optional<ContentEntity> optionalContent = contentRepository.findById(contentId);
            if (optionalContent.isPresent()) {
                contentRepository.deleteById(contentId);
                return ResponseEntity.ok("콘텐츠가 삭제되었습니다.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("콘텐츠 삭제 중 에러가 발생했습니다.");
        }
    }

    @PutMapping("/contents/{contentId}")
    public ResponseEntity<ContentEntity> updateContent(@PathVariable Long contentId, @RequestBody ContentDTO contentDTO) {
        try {
            Optional<ContentEntity> optionalContent = contentRepository.findById(contentId);
            if (optionalContent.isPresent()) {
                // 콘텐츠가 존재하는 경우 수정
                ContentEntity existingContent = optionalContent.get();
                existingContent.setContentName(contentDTO.getContentName());
                existingContent.setContentContent(contentDTO.getContentContent());

                ContentEntity updatedContent = contentRepository.save(existingContent);
                return ResponseEntity.ok(updatedContent);
            } else {
                // 콘텐츠가 없는 경우 404 Not Found 상태 반환
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 수정 도중 에러가 발생했을 때 500 Internal Server Error 상태와 함께 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

