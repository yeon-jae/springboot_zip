package com.practice.springboot.learningspringboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
//1. restAPI만들기-RestController주석 사용
@RestController
public class ProductController {
    //courses , Course: id,name,author
//3.product : 누군가 /product를 입력하면 코스 목록을 반환
    @RequestMapping("/product")
    public List<Product> retrieveAllProducts() {
        return Arrays.asList(
                new Product(1, "AAA", "일회용마스크", "황사,코로나 예방", 9000),
                new Product(2, "Acd", "선크림", "자외선 차단", 20000)
                );
    }
}
