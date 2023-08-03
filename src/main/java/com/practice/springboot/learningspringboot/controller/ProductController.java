package com.practice.springboot.learningspringboot.controller;

import com.practice.springboot.learningspringboot.dto.ProductItem;
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
public class ProductController {
    //courses , Course: id,name,author
//3.product : 누군가 /product를 입력하면 코스 목록을 반환
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody ProductItem productItem){
        return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully");
    }






    @GetMapping("/products")
    public String product(ProductItem productItem){
        System.out.println(productItem.getProductId());
        System.out.println(productItem.getProductCode());
        System.out.println(productItem.getProductName());
        System.out.println(productItem.getProductPurpose());
        System.out.println(productItem.getProductPrice());

        return productItem.toString();
    }





}
