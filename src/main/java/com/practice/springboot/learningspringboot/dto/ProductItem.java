package com.practice.springboot.learningspringboot.dto;


public class ProductItem {

    /*
    {
            "productId":1,
            "productCode:AAA",
            "productName":"일회용마스크",
            "productPurpose":"황사, 코로나 예방",
            "productPrice":"가격"
            }

     */
    //2.포함할 모든 속성을 정의
    private long productId;
    private String productCode;
    private String productName;
    private String productPurpose;
    private int productPrice;

    //constructor
    public ProductItem(long productId, String productCode, String productName, String productPurpose, int productPrice) {
        super();
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productPurpose = productPurpose;
        this.productPrice = productPrice;
    }

    //getter

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPurpose() {
        return productPurpose;
    }

    public void setProductPurpose(String productPurpose) {
        this.productPurpose = productPurpose;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }


    //setter

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPurpose='" + productPurpose + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
