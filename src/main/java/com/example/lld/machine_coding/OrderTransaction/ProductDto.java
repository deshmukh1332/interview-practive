package com.example.lld.machine_coding.OrderTransaction;

public class ProductDto {
    final Integer productId;
    ProductStatus productStatus;
    int count;
    int noOfRetry;

    public ProductDto(Integer id, int count) {
        this.productId = id;
        this.count = count;
        this.productStatus = ProductStatus.PAYMENT_PENDING;
        this.noOfRetry = 0;
    }
}
