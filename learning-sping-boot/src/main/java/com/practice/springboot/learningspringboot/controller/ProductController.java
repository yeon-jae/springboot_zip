package com.practice.springboot.learningspringboot.controller;
import com.practice.springboot.learningspringboot.dto.ProductDTO;
import com.practice.springboot.learningspringboot.entity.ProductEntity;
import com.practice.springboot.learningspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    
    //포스트_상품 등록
    @PostMapping("/products")
    public ResponseEntity<ProductEntity> postProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductEntity productEntity =ProductEntity.productEntity(productDTO);

            ProductEntity savedProduct=productRepository.save(productEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            // 500에러
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //등록 상품 조회
    @GetMapping("/products/{productId}")
        public ResponseEntity<ProductEntity> getProduct(@PathVariable Long productId) {
            try {
                Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
                if (optionalProduct.isPresent()) {
                     ProductEntity productEntity = optionalProduct.get();
                    return ResponseEntity.ok(productEntity);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        //삭제
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        try {
            Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
            if (optionalProduct.isPresent()) {
                productRepository.deleteById(productId);
                return ResponseEntity.ok("상품이 삭제되었습니다.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상품 삭제 중 에러가 발생했습니다.");
        }
    }




    @PutMapping("/products/{productId}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        try {
            Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
            if (optionalProduct.isPresent()) {
                // 콘텐츠가 존재하는 경우 수정
                ProductEntity existingProduct = optionalProduct.get();
                existingProduct.setProductCode(productDTO.getProductCode());
                existingProduct.setProductName(productDTO.getProductName());
                existingProduct.setProductPurpose(productDTO.getProductPurpose());
                existingProduct.setProductPrice(productDTO.getProductPrice());

                ProductEntity updatedProduct = productRepository.save(existingProduct);
                return ResponseEntity.ok(updatedProduct);
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

