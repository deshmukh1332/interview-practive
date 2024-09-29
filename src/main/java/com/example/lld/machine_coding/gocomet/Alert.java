package com.example.lld.machine_coding.gocomet;

public class Alert {
    private Integer userId;
    private  Integer productId;
    private  Integer newPrice;

    public Alert(Integer userId, Integer productId, Integer newPrice) {
        this.userId = userId;
        this.productId = productId;
        this.newPrice = newPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getNewPrice() {
        return newPrice;
    }
}