package com.practice.springboot.learningspringboot.entity;

import com.practice.springboot.learningspringboot.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "product_Item")
public class ProductEntity {//table 역할
   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private long productId;
    @Column
    private String productCode;

    @Column
    private String productName;
    @Column
    private String productPurpose;

    @Column
    private int productPrice;
    public static ProductEntity productEntity(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setProductCode(productDTO.getProductCode());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductPurpose(productDTO.getProductPurpose());
        productEntity.setProductPrice(productDTO.getProductPrice());
        return productEntity;
    }

}
